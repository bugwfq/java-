package net.serverToClient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		//����������
		ServerSocket ss = new ServerSocket(8080);
		//��������ȴ�����client���ͻ��ˣ���Ӧ
		Socket s = ss.accept();
		//��ӡ���ͻ�����Ϣ
		System.out.println(s);
		
		
		//������������ͻ�������
		DataInputStream dis = new DataInputStream(s.getInputStream());
		while(true){
			//��ȡ�ͻ�����Ϣ
			String message = dis.readUTF();
			if(message.contains("over")){
				break;
			}
			System.out.println("�յ��ͻ�����Ϣ:"+message);
			
		}
		dis.close();
		ss.close();
		
	}
}
