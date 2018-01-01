package IOStream.day170606.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ObjectOutputStreamTest {
	/**
	 * ��һ��java�����еĶ���д���ļ��������̽����л�.
	 * ���л��������ʵ��java.io.Serializable
	 */
	@Test
	public void test1()throws Exception{
		
		User user = new User(1,"admin");//����User����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/test/user.txt")));
		oos.writeObject(user);//���л�(������д���ļ���)
		oos.close();
	}
	

}
