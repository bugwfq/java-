package net.DatagramSocketAndDatagramPacket.common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpClient {
	public static void main(String[] args) throws SocketException {
		//�����շ���
		DatagramSocket socket = new DatagramSocket(8888);
		
		
		
		//�����������������
		byte[] b = new byte[1024];
		
		//�������ܷ��͵İ��ļ�
		
		DatagramPacket receivePacket = new DatagramPacket(b,b.length);
		
		//��������ʽ���ܷ���
		try {
			socket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length = receivePacket.getLength();
		//�����ܵ���byte����ת��Ϊ�ַ���
		String message = new String(b,0,length);
		System.out.println("�յ�һ�����ݣ�"+message);
		socket.close();
		
	}
}
