package net.DatagramSocketAndDatagramPacket.Thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient1 {
	public static void main(String[] args) throws IOException {
		//创建收发器
		DatagramSocket socket = new DatagramSocket(7777);
		
		//创建发送线程
		OutThread out = new OutThread(socket,8888);
		//设置为守护线程
		out.setDaemon(true);
		out.start();
		
		while(true){
			//读取信息的数组
			byte[] read = new byte[2046];
			//接受包的打包器
			DatagramPacket packet = new DatagramPacket(read,read.length);
			//创建阻塞式接受包方法
			socket.receive(packet);
			//获取真实接受数据长度
			int length = packet.getLength();
			//截取实际发送的内容
			String message = new String(read,0,length);
			System.out.println("收到Client2消息："+message);
			if(message.equals("bye")){
				out.write(message);
				break;
			}
			
		}
		socket.close();
		
	}
}
