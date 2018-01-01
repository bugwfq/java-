package net.DatagramSocketAndDatagramPacket.Thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class OutThread extends Thread{
	private DatagramSocket socket;
	private int port;
	private Scanner input = new Scanner(System.in);
	/**
	 * 创建数据报套接字并将其绑定到本地主机上的指定端口。
	 * @param socket 数据报套接字
	 * @param port 指定端口。
	 */
	public OutThread(DatagramSocket socket,int port){
		this.socket = socket;
		this.port = port;
		input.useDelimiter("\n");
	}
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("请输入：");
				String message = input.next();
				write(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void write(String message) throws IOException{
		
		message = message.trim();
		//将输入据封装到数据包中
		DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length,InetAddress.getLocalHost(),port);
		//发送数据
		socket.send(packet);
	}
}
