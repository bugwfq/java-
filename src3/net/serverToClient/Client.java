package net.serverToClient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost",8881);
		
		OutputStream os = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bf = new BufferedWriter(osw);
		bf.write("Íõ¸£Ç¿");
		bf.newLine();
		bf.flush();
		bf.close();
		s.close();
	}
}
