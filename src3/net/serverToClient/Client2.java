package net.serverToClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//����һ���ַ�������
		Scanner input = new Scanner(System.in);
		//�����ȡ����  �ı�ָʽ
		input.useDelimiter("\n");
		//����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ںš� 
		Socket s = new Socket("127.0.0.1",8080);
		
		//����������ܵ����������ͨ
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while(true){
			//��ͻ���д����Ϣ
			String message = input.next();
			
			dos.writeUTF(message);
			dos.flush();
			if(message.contains("over")){
				break;
			}
			
		}
		dos.close();
		s.close();
	}
}
