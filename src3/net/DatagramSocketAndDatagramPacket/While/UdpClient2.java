package net.DatagramSocketAndDatagramPacket.While;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient2 {
	public static void main(String[] args) throws IOException {
		//创建输入端
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//改变默认结束标记
		input.useDelimiter("\n");
		//创建收发服务器
		DatagramSocket socket = new DatagramSocket(8888);
		
		
		while(true){
			byte[] message = new byte[2046];
			//创建数据打包器
			DatagramPacket receivePacket = new DatagramPacket(message,message.length);
			//创建阻塞式接受方法
			socket.receive(receivePacket);
			//获取实际接受长度
			int length = receivePacket.getLength();
			String strMessage = new String(message,0,length);
			if(strMessage.equals("bye")){
				break;
			}
			System.out.println();
			
			String str = input.next();
			str = str.trim();
			DatagramPacket sendPacket = new DatagramPacket(str.getBytes(),str.getBytes().length,InetAddress.getLocalHost(),7777);
			
			socket.send(sendPacket);
			
			
		}
		socket.close();
		
	}
}
