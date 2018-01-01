package net.serverToClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建一个字符输入流
		Scanner input = new Scanner(System.in);
		//解决读取阻塞  改变分割方式
		input.useDelimiter("\n");
		//创建一个流套接字并将其连接到指定主机上的指定端口号。 
		Socket s = new Socket("127.0.0.1",8080);
		
		//建立输出流管道与服务器连通
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while(true){
			//向客户端写入消息
			String message = input.next();
			
			dos.writeUTF(message);
			dos.flush();
			if(message.contains("over")){
				break;
			}
			
		}
		dos.close();
		s.close();
	}
}
