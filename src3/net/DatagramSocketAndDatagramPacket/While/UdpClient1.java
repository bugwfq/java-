package net.DatagramSocketAndDatagramPacket.While;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient1 {
	public static void main(String[] args) throws IOException {
		//创建输入端
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//改变默认结束标记
		input.useDelimiter("\n");
		//创建服务器
		DatagramSocket socket = new DatagramSocket(7777);
		
		while(true){
			String message = input.next();
			message = message.trim();
			//创建数据打包器
			DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length,InetAddress.getLocalHost(),8888);
			
			//发送数据
			socket.send(packet);
			//创建接受数据的数组
			byte[] read = new byte[2046];
	
			//创建接受数据的打包器
			DatagramPacket receivePacket = new DatagramPacket(read,read.length);
			
			//创建阻塞式接受数据方法
			socket.receive(receivePacket);
			//获取实际接受长度
			int length = receivePacket.getLength();
			String str = new String(read,0,length);
			if(str.equals("bye")){
				break;
			}
			System.out.println("接受到Client2消息："+str);
			
		}
		socket.close();
	}
}
