package net.DatagramSocketAndDatagramPacket.While;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient2 {
	public static void main(String[] args) throws IOException {
		//���������
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//�ı�Ĭ�Ͻ������
		input.useDelimiter("\n");
		//�����շ�������
		DatagramSocket socket = new DatagramSocket(8888);
		
		
		while(true){
			byte[] message = new byte[2046];
			//�������ݴ����
			DatagramPacket receivePacket = new DatagramPacket(message,message.length);
			//��������ʽ���ܷ���
			socket.receive(receivePacket);
			//��ȡʵ�ʽ��ܳ���
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
