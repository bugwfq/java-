package IOStream.day170602.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class ByteArrayInputTest {
	@Test
	public void test(){
		byte[] bs = {97,98,99,100,101,102};
		ByteArrayInputStream bis = new ByteArrayInputStream(bs);
		int mark = 0;
		while((mark=bis.read())!=-1){
			System.out.println((char)mark);
		}
		try {
			bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}



