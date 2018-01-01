package net.DatagramSocketAndDatagramPacket.common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpClient {
	public static void main(String[] args) throws SocketException {
		//创建收发器
		DatagramSocket socket = new DatagramSocket(8888);
		
		
		
		//创建接受输入的容器
		byte[] b = new byte[1024];
		
		//创建接受发送的包文件
		
		DatagramPacket receivePacket = new DatagramPacket(b,b.length);
		
		//创建阻塞式接受方法
		try {
			socket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length = receivePacket.getLength();
		//将接受到的byte数组转换为字符串
		String message = new String(b,0,length);
		System.out.println("收到一条数据："+message);
		socket.close();
		
	}
}
