package net.netCommunication.test.usersChatroom;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutThread  extends Thread{
	private BufferedWriter bw;
	private Scanner input = new Scanner(System.in);
	public OutThread(BufferedWriter bw){
		input.useDelimiter("\n");
		this.bw = bw;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("«Î ‰»Î£∫");
				bw.write(input.next());
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
