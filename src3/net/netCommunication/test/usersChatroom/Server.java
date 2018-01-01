package net.netCommunication.test.usersChatroom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\n");
		//创建服务器
		ServerSocket ss = new ServerSocket(8888);
		
		//创建套接字接收连接
		Socket s = ss.accept();

		
		//显示客户端信息
		System.out.println(s);
		
		//创建与客户端连接的输入流和输出流
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		OutThread ot = new OutThread(bw);
		ot.setDaemon(true);
		ot.start();
		
		String message;
		while(true){
			//服务端先读
			message = br.readLine() ;
			
			if(message == null ||message.trim().equals("over")){
				break;
			}
			
			System.out.println("收到客户端消息："+message);
			
		}
		br.close();
		bw.close();
		s.close();
		ss.close();
	}
}
