package net.DatagramSocketAndDatagramPacket.Thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient2 {
	public static void main(String[] args) throws IOException {
		//创建收发器
		DatagramSocket socket = new DatagramSocket(8888);
		
		//创建发送线程
		OutThread out = new OutThread(socket,7777);
		//设置为守护线程
		out.setDaemon(true);
		out.start();
		
		while(true){
			byte[] read = new byte[2046];
			//创建接受打包器
			DatagramPacket receivePacket = new DatagramPacket(read,read.length);
			//创建阻塞式接受
			socket.receive(receivePacket);
			//获取接受消息实际长度
			int length = receivePacket.getLength();
			String message = new String(read,0,length);
			System.out.println("收到Client1消息:"+message);
			if(message.equals("bye")){
				out.write(message);
				break;
			}
			
		}
		socket.close();
	}
}
