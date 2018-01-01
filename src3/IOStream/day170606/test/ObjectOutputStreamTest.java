package IOStream.day170606.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ObjectOutputStreamTest {
	/**
	 * 将一个java程序中的对象写进文件里，这个过程叫序列化.
	 * 序列化的类必须实现java.io.Serializable
	 */
	@Test
	public void test1()throws Exception{
		
		User user = new User(1,"admin");//创建User对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/test/user.txt")));
		oos.writeObject(user);//序列化(将对象写入文件里)
		oos.close();
	}
	

}
