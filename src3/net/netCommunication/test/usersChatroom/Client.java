package net.netCommunication.test.usersChatroom;

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
		Socket s = new Socket("192.168.14.53",8888);
		
		//创建与服务端链接的输入输出流
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		OutThread ot = new OutThread(bw);
		ot.setDaemon(true);
		
		ot.start();
		String message;
		while(true){
			//写完再读
			message = br.readLine();
			if(message == null || message.trim().equals("over")){
				break;
			}
			System.out.println("收到服务端消息："+message);
			

		}
		br.close();
		br.close();
		s.close();
	}
}
