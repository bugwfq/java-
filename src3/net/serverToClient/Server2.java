package net.serverToClient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		//创建服务器
		ServerSocket ss = new ServerSocket(8080);
		//创建对象等待接受client（客户端）回应
		Socket s = ss.accept();
		//打印出客户端信息
		System.out.println(s);
		
		
		//建立输入流与客户端连接
		DataInputStream dis = new DataInputStream(s.getInputStream());
		while(true){
			//读取客户端消息
			String message = dis.readUTF();
			if(message.contains("over")){
				break;
			}
			System.out.println("收到客户端消息:"+message);
			
		}
		dis.close();
		ss.close();
		
	}
}
