package IOStream.day170602.test;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class StringReaderTest {
	 //@Test
	 public void test1() throws IOException{
		 String s = "hello world";
		 StringReader sr = new StringReader(s);
//		 System.out.println(sr.markSupported());//true
		 sr.mark(3);
		 System.out.println((char)sr.read());
		 System.out.println((char)sr.read());
		 System.out.println((char)sr.read());
		 System.out.println((char)sr.read());
		 sr.reset();
		 System.out.println((char)sr.read());
		 System.out.println((char)sr.read());
		 System.out.println((char)sr.read());
	 }
	 
	 @Test
	 public void test2(){
		 String str = "hello world";
		 StringReader sr = new StringReader(str);
		 char[] cs = new char[str.length()];
		 try {
			sr.read(cs,0,str.length());
			String newS = new String(cs);
			System.out.println(newS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
