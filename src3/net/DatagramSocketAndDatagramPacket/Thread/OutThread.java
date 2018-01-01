package net.DatagramSocketAndDatagramPacket.Thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class OutThread extends Thread{
	private DatagramSocket socket;
	private int port;
	private Scanner input = new Scanner(System.in);
	/**
	 * �������ݱ��׽��ֲ�����󶨵����������ϵ�ָ���˿ڡ�
	 * @param socket ���ݱ��׽���
	 * @param port ָ���˿ڡ�
	 */
	public OutThread(DatagramSocket socket,int port){
		this.socket = socket;
		this.port = port;
		input.useDelimiter("\n");
	}
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("�����룺");
				String message = input.next();
				write(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void write(String message) throws IOException{
		
		message = message.trim();
		//������ݷ�װ�����ݰ���
		DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length,InetAddress.getLocalHost(),port);
		//��������
		socket.send(packet);
	}
}
