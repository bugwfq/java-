package IOStream.day170606.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.junit.Test;

public class ObjectInputStreamTest {
	/**
	 * 反序列化：将文件中的对象读出到程序中
	 */
	
	@Test
	public void test()throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src3/day170606/test/user.txt")));
		User user = (User)ois.readObject();
		System.out.println(user);
		ois.close();
	}
}
