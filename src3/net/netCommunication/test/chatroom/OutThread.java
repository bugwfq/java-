package net.netCommunication.test.chatroom;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutThread  extends Thread{
	private BufferedWriter bw;
	private Scanner input = new Scanner(System.in);
	public OutThread(BufferedWriter bw){
		this.bw = bw;
	}
	
	@Override
	public void run() {
		while(true){
			input.useDelimiter("\n");
			
			try {
				System.out.println("«Î ‰»Î£∫");
				bw.write(input.next());
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
