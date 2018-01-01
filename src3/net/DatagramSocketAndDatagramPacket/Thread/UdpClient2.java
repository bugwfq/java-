package net.DatagramSocketAndDatagramPacket.Thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient2 {
	public static void main(String[] args) throws IOException {
		//�����շ���
		DatagramSocket socket = new DatagramSocket(8888);
		
		//���������߳�
		OutThread out = new OutThread(socket,7777);
		//����Ϊ�ػ��߳�
		out.setDaemon(true);
		out.start();
		
		while(true){
			byte[] read = new byte[2046];
			//�������ܴ����
			DatagramPacket receivePacket = new DatagramPacket(read,read.length);
			//��������ʽ����
			socket.receive(receivePacket);
			//��ȡ������Ϣʵ�ʳ���
			int length = receivePacket.getLength();
			String message = new String(read,0,length);
			System.out.println("�յ�Client1��Ϣ:"+message);
			if(message.equals("bye")){
				out.write(message);
				break;
			}
			
		}
		socket.close();
	}
}
