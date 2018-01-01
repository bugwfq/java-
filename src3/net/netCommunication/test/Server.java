package net.netCommunication.test;

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
		Socket s2 = ss.accept();
		//显示客户端信息
		System.out.println(s);
		System.out.println(s2);
		//创建与客户端连接的输入流和输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));

		while(true){

			String message = br.readLine() ;
			if(message == null ||message.trim().equals("over")){
				break;
			}
			bw2.write(message);
			bw2.newLine();
			bw2.flush();
			String message2 = br2.readLine() ;

			System.out.println(message2);
			if(message2 == null ||message2.trim().equals("over")){
				break;
			}
			
			
			
			
			
			
			
			//服务端先读
			
//			System.out.println("收到客户端消息："+message);
			//读完再写
			bw.write(message2);
			bw.newLine();
			bw.flush();
			
		}
		br.close();
		bw.close();
		s.close();
		ss.close();
	}
}
