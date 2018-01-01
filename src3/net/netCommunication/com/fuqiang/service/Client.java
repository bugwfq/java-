package net.netCommunication.com.fuqiang.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket socket = null ;
	BufferedWriter bw = null;
	BufferedReader br = null;
	public void start() {
		Socket socket = null ;
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			socket = new Socket("localhost",8888);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			WriterThread writer = new WriterThread(bw);
			writer.setDaemon(true);
			writer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			String message = null;
			try {
				message = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(message);
			if(message.trim().equals("bye")){
				break;
			}
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class WriterThread extends Thread{
		private Scanner input = new Scanner(System.in);
		BufferedWriter bw;
		public WriterThread(BufferedWriter bw){
			this.bw = bw;
			input.useDelimiter("\n");
			try {
				System.out.println("欢迎登录xxx聊天室，该聊天室支持多人聊天，如需私聊请  @（您要私聊的用户昵称）  退出请输入bye");
				System.out.println("请输入在该聊天室中昵称：");
				bw.write(input.next());
				bw.flush();
				System.out.println("请输入账号密码：");
				bw.write(input.next());
				bw.flush();
				System.out.println("登录成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while(true){
				String message = input.next();
				writer(message);
			}
		}
		public void writer(String message){
			try {
				bw.write(message);
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
