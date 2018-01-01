package thread.day170612.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ExamTest/* implements Face*/{
	/*private static int count;
	
	public static void main(String[] args) {
		System.out.println(++count);//----------->>> 1
	}*/
	
	public static void main(String[] args) {
		String str = "abcdefghijk";
		byte[] strBuf = str.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(strBuf);
		int data = bais.read();
		while(data != -1){
			char upper = Character.toUpperCase((char)data);
			System.out.print(upper+" ");//A B C D E F G H I J K 
			data = bais.read();
		}
		try {
			bais.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*interface Face{
	int count = 40;
}*/