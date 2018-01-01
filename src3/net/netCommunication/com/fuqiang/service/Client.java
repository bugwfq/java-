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
				System.out.println("��ӭ��¼xxx�����ң���������֧�ֶ������죬����˽����  @����Ҫ˽�ĵ��û��ǳƣ�  �˳�������bye");
				System.out.println("�������ڸ����������ǳƣ�");
				bw.write(input.next());
				bw.flush();
				System.out.println("�������˺����룺");
				bw.write(input.next());
				bw.flush();
				System.out.println("��¼�ɹ���");
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
