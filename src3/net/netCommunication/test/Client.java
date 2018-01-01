package net.netCommunication.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\n");
		// 创建一个流套接字并将其连接到指定主机上的指定端口号。
		Socket s = new Socket("localhost",8888);
		
		//创建与服务端链接的输入输出流
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String message;
		while(true){
			//客户端先写
			System.out.println("请输入：");
			bw.write(input.next());
			bw.flush();
			
			//写完再读
			message = br.readLine();
			if(message == null || message.trim().equals("over")){
				break;
			}
			System.out.println("收到服务端消息："+message);

		}
		br.close();
		br.close();
		bw.close();
		s.close();
	}
}
