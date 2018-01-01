package net.netCommunication.test.usersChatroom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\n");
		//����������
		ServerSocket ss = new ServerSocket(8888);
		
		//�����׽��ֽ�������
		Socket s = ss.accept();

		
		//��ʾ�ͻ�����Ϣ
		System.out.println(s);
		
		//������ͻ������ӵ��������������
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		OutThread ot = new OutThread(bw);
		ot.setDaemon(true);
		ot.start();
		
		String message;
		while(true){
			//������ȶ�
			message = br.readLine() ;
			
			if(message == null ||message.trim().equals("over")){
				break;
			}
			
			System.out.println("�յ��ͻ�����Ϣ��"+message);
			
		}
		br.close();
		bw.close();
		s.close();
		ss.close();
	}
}
