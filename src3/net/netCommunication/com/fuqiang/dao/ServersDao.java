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
	private Servers servers;//��������
	private ServerSocket sockets;//������
	private static HashMap<User,Socket> socketsMap;//��¼���û�����
	private static ExecutorService execu = Executors.newCachedThreadPool();
	public ServersDao(){
		try {
			servers = new Servers();//�������������������ʷ�����
		} catch (IOException e) {
			e.printStackTrace();
		}
		sockets = servers.getServers();//��ȡ������
		socketsMap = servers.getSockets();//��ȡ��¼�ļ���
	}
	/**
	 * ���ܷ���˷��ص���������
	 * @throws IOException
	 */
	public void connect() throws IOException{
		while(true){
			//�������Ӷ���
			Socket socket = sockets.accept();
			//�������ͻ��˵�������Ϣ�������˵Ķ�ȡ��
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//���ܵ��Ķ�����Ϣ
			User u = new User(bf.readLine(),bf.readLine());
			//���û���Ϣ��������Ϣ���뼯����
			socketsMap.put(u, socket);
			//����̨�����¼�û���
			System.out.println(u.getName()+"��¼");
			//���������ӿͻ����߳�
			ServerThread thread = new ServerThread(socket,u);
			execu.submit(thread);
//			//�����߳�����Ϊ�ػ��߳�
//			thread.setDaemon(true);
//			//�������߳�
//			thread.start();
		}
	}
	/**
	 * ��������ÿ������ͻ��Ķ�ȡ��������߳�
	 * @author Administrator
	 *
	 */
	private class ServerThread extends Thread{
		BufferedReader br;//���̵߳Ķ�ȡ��
		User user;//���߳������û���Ϣ
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
		 * ��ȡ�ͻ���д�����Ϣ������������
		 * @return
		 * @throws IOException
		 */
		private String read() throws IOException{
			String read = br.readLine();
			return read;
		}
		/**
		 * �ͻ��˷�������Ϣ
		 * @param message
		 * @throws IOException
		 */
		private void writer(String message) throws IOException{
			if(message==null){
				return;
			}
			//��ȡ���������û�����
			Set<User> keys=socketsMap.keySet();
			//�鿴�Ƿ���˽��@����
			if(message.contains("@")){
				//����������
				for (Iterator<User> iter = keys.iterator();iter.hasNext();) {
					User u = iter.next();
					if(message.contains(u.getName())){
						Socket userSocket = socketsMap.get(u);
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(userSocket.getOutputStream()));
						message = message.replace("@"+u.getName(), "");
						bw.write(user.getName()+" �����Ļ����㣺"+message);
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
				System.out.println(user.getName()+"����");
			}
		}
		/**
		 * Ⱥ����Ϣ��������
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
				bw.write(user.getName()+"��"+message);
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
	 * �رշ�����
	 * @throws IOException
	 */
	public void close() throws IOException{
		servers.close();
	}
}
