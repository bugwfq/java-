package net.DatagramSocketAndDatagramPacket.Thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient1 {
	public static void main(String[] args) throws IOException {
		//�����շ���
		DatagramSocket socket = new DatagramSocket(7777);
		
		//���������߳�
		OutThread out = new OutThread(socket,8888);
		//����Ϊ�ػ��߳�
		out.setDaemon(true);
		out.start();
		
		while(true){
			//��ȡ��Ϣ������
			byte[] read = new byte[2046];
			//���ܰ��Ĵ����
			DatagramPacket packet = new DatagramPacket(read,read.length);
			//��������ʽ���ܰ�����
			socket.receive(packet);
			//��ȡ��ʵ�������ݳ���
			int length = packet.getLength();
			//��ȡʵ�ʷ��͵�����
			String message = new String(read,0,length);
			System.out.println("�յ�Client2��Ϣ��"+message);
			if(message.equals("bye")){
				out.write(message);
				break;
			}
			
		}
		socket.close();
		
	}
}
