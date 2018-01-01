package net.DatagramSocketAndDatagramPacket.While;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient1 {
	public static void main(String[] args) throws IOException {
		//���������
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//�ı�Ĭ�Ͻ������
		input.useDelimiter("\n");
		//����������
		DatagramSocket socket = new DatagramSocket(7777);
		
		while(true){
			String message = input.next();
			message = message.trim();
			//�������ݴ����
			DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length,InetAddress.getLocalHost(),8888);
			
			//��������
			socket.send(packet);
			//�����������ݵ�����
			byte[] read = new byte[2046];
	
			//�����������ݵĴ����
			DatagramPacket receivePacket = new DatagramPacket(read,read.length);
			
			//��������ʽ�������ݷ���
			socket.receive(receivePacket);
			//��ȡʵ�ʽ��ܳ���
			int length = receivePacket.getLength();
			String str = new String(read,0,length);
			if(str.equals("bye")){
				break;
			}
			System.out.println("���ܵ�Client2��Ϣ��"+str);
			
		}
		socket.close();
	}
}
