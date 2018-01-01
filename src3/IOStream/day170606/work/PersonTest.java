package IOStream.day170606.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class PersonTest {
	//@Test
	public void test1() throws FileNotFoundException, IOException{
		Addr add = new Addr("beijing");//ͬһ������ֻ�����л�һ��
		Person p1 = new Person(1,"admin",add);
		Person p2 = new Person(2,"simmon",add);
		//���л�(Ҫ��ʵ��Serializable�ӿ�):�������еĶ���д���ļ���
		ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/work/person.txt")));
		oop.writeObject(add);
		oop.writeObject(p1);
		oop.writeObject(p2);
		oop.close();
	}
	
	//@Test
	public void test2() throws FileNotFoundException, IOException, ClassNotFoundException{
		//�����л������ļ���Ķ�����������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src3/day170606/work/person.txt")));
		Addr add = (Addr)ois.readObject();
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
		
	}
	
	@Test
	public void test3() throws FileNotFoundException, IOException{
		//���л��׶�
		Addr add = new Addr("beijing");
		Person p1 = new Person(1,"admin",add);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/work/person.txt")));
		oos.writeObject(add);
		oos.writeObject(p1);
		
		add.setDesc("lanzhou");
		Person p2 = new Person(2,"simmon",add);//ֵû�б��ı�
		oos.writeObject(p2);
		oos.close();
	}
	
	@Test
	public void test4() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src3/day170606/work/person.txt")));
		Addr add = (Addr)ois.readObject();
		Person p1 = (Person)ois.readObject();
		Person p2 = (Person)ois.readObject();
		
		System.out.println(p1.getAdd());
		System.out.println(p2.getAdd());
		System.out.println(add);
	}
}
