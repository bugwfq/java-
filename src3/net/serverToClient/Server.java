package net.serverToClient;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket s = new ServerSocket(8881);
		Socket socket = s.accept();
		System.out.println(socket);
		InputStream is = socket.getInputStream();
		InputStreamReader isw = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isw);
		System.out.println(br.readLine());
			
		br.close();
		s.close();
	}
}
