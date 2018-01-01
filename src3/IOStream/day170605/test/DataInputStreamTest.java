package IOStream.day170605.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

public class DataInputStreamTest {
	
	
	@Test
	public void test2()throws Exception{
		DataInputStream dis = new DataInputStream(new FileInputStream(new File("src3/day170605/test/data1.txt")));
		/*int mark = 0;
		while((mark=dis.read())!=-1){
			System.out.println((char)mark);
		}*/
/*		int i = dis.readInt();
		int i1 = dis.readInt();
		int i2 = dis.readInt();*/
		int a =dis.readInt();
		double d = dis.readDouble();
		System.out.println(a);
		
		System.out.println(d);
		dis.close();
//		System.out.println(d);
		
	}
}
