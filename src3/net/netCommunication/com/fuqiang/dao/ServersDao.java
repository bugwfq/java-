package net.netCommunication.com.fuqiang.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.netCommunication.com.fuqiang.entity.User;
import net.netCommunication.com.servers.Servers;
public class ServersDao {
	private Servers servers;//服务器类
	private ServerSocket sockets;//服务器
	private static HashMap<User,Socket> socketsMap;//登录的用户管理
	private static ExecutorService execu = Executors.newCachedThreadPool();
	public ServersDao(){
		try {
			servers = new Servers();//创建服务器类用来访问服务器
		} catch (IOException e) {
			e.printStackTrace();
		}
		sockets = servers.getServers();//获取服务器
		socketsMap = servers.getSockets();//获取登录的集合
	}
	/**
	 * 接受服务端返回的连接详情
	 * @throws IOException
	 */
	public void connect() throws IOException{
		while(true){
			//接受连接对象
			Socket socket = sockets.accept();
			//用来将客户端的链接信息传入服务端的读取流
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//接受到的对象信息
			User u = new User(bf.readLine(),bf.readLine());
			//将用户信息与连接信息存入集合中
			socketsMap.put(u, socket);
			//控制台输出登录用户名
			System.out.println(u.getName()+"登录");
			//启动该连接客户的线程
			ServerThread thread = new ServerThread(socket,u);
			execu.submit(thread);
//			//将该线程设置为守护线程
//			thread.setDaemon(true);
//			//启动该线程
//			thread.start();
		}
	}
	/**
	 * 服务类中每个连入客户的读取和输出流线程
	 * @author Administrator
	 *
	 */
	private class ServerThread extends Thread{
		BufferedReader br;//该线程的读取流
		User user;//该线程所属用户信息
		ServerThread(Socket socket,User u) {
			this.user = u;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 读取客户端写入的消息（阻塞方法）
		 * @return
		 * @throws IOException
		 */
		private String read() throws IOException{
			String read = br.readLine();
			return read;
		}
		/**
		 * 客户端发出的消息
		 * @param message
		 * @throws IOException
		 */
		private void writer(String message) throws IOException{
			if(message==null){
				return;
			}
			//获取所有在线用户名单
			Set<User> keys=socketsMap.keySet();
			//查看是否是私聊@符号
			if(message.contains("@")){
				//遍历所有人
				for (Iterator<User> iter = keys.iterator();iter.hasNext();) {
					User u = iter.next();
					if(message.contains(u.getName())){
						Socket userSocket = socketsMap.get(u);
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(userSocket.getOutputStream()));
						message = message.replace("@"+u.getName(), "");
						bw.write(user.getName()+" 发悄悄话给你："+message);
						bw.newLine();
						bw.flush();
						return;
					}
				}
			}
			writerAll(keys,message);
			if(message.trim().equals("bye")){
				Socket userSocket = socketsMap.get(user);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(userSocket.getOutputStream()));
				bw.write("bye");
				bw.newLine();
				bw.flush();
				
				socketsMap.remove(user);
				System.out.println(user.getName()+"下线");
			}
		}
		/**
		 * 群发消息给所有人
		 * @param keys
		 * @param message
		 * @throws IOException
		 */
		private void writerAll(Set<User> keys,String message) throws IOException {
			if(message==null){
				return;
			}
			for(Iterator<User> iter = keys.iterator();iter.hasNext();){
				User tempU = iter.next();
				if(this.user.equals(tempU)){
					continue;
				}
				Socket userSocket = socketsMap.get(tempU);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(userSocket.getOutputStream()));
				bw.write(user.getName()+"："+message);
				bw.newLine();
				bw.flush();
				
			}
		}
		@Override
		public void run() {
			while(true){
				try {
					String message = read();
					if(message==null){
						return;
					}
					writer(message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 关闭服务器
	 * @throws IOException
	 */
	public void close() throws IOException{
		servers.close();
	}
}
