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
		Addr add = new Addr("beijing");//同一个对象只被序列化一次
		Person p1 = new Person(1,"admin",add);
		Person p2 = new Person(2,"simmon",add);
		//序列化(要先实现Serializable接口):将程序中的对象写入文件中
		ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/work/person.txt")));
		oop.writeObject(add);
		oop.writeObject(p1);
		oop.writeObject(p2);
		oop.close();
	}
	
	//@Test
	public void test2() throws FileNotFoundException, IOException, ClassNotFoundException{
		//反序列化：将文件里的对象读入程序中
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src3/day170606/work/person.txt")));
		Addr add = (Addr)ois.readObject();
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
		
	}
	
	@Test
	public void test3() throws FileNotFoundException, IOException{
		//序列化弊端
		Addr add = new Addr("beijing");
		Person p1 = new Person(1,"admin",add);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/work/person.txt")));
		oos.writeObject(add);
		oos.writeObject(p1);
		
		add.setDesc("lanzhou");
		Person p2 = new Person(2,"simmon",add);//值没有被改变
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
