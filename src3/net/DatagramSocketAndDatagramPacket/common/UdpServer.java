package net.DatagramSocketAndDatagramPacket.common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
	public static void main(String[] args) throws IOException {
		//创建收发器
		DatagramSocket socket = new DatagramSocket();
		String message = "hello word!";
		//把要发送的输入包装
		DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getLocalHost(), 8888);
		//发送数据
		socket.send(packet);
		
		socket.close();
	}
}
