package net.DatagramSocketAndDatagramPacket.common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
	public static void main(String[] args) throws IOException {
		//�����շ���
		DatagramSocket socket = new DatagramSocket();
		String message = "hello word!";
		//��Ҫ���͵������װ
		DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getLocalHost(), 8888);
		//��������
		socket.send(packet);
		
		socket.close();
	}
}
