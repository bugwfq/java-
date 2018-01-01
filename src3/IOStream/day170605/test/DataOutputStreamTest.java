package IOStream.day170605.test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class DataOutputStreamTest {
	@Test
	public void test1()throws Exception{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("src3/day170605/test/data1.txt")));
		
//		dos.writeFloat(0.12f);

//		dos.writeInt(2000);	
		/*dos.writeDouble(100000000000.0000);
		dos.flush();
		*/
		dos.writeInt(1000);
		dos.writeDouble(10000.00);
		dos.close();
		
		
	}
}
