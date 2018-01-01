package IOStream.day170606.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test5()throws Exception{
		/**
		 * 5.定义一个电脑类(Computer),里面有cpu(cpu名称),mem(内存名称),disk(硬盘大小),User(使用者),
		 * User也是用户自己定义的一个类,里面有name和age两个字段,要求通过系统运行的时候,根据用户选择,
		 * 通过控制台输入三台电脑上述配置,然后序列化到硬盘上面,序列化的时候不需要保存cpu的信息,
		 * 然后第\二次登录的时候根据用户选项可以从硬盘上面读取这三台电脑的信息,然后打印到控制台.
		 * 考点(序列化 ,反序列化,Scanner,序列化的时候某个字段不需要系列化.
		 * 序列化要实现的接口( Serializable ),transient
		 */
		
		User user1 = new User("admin1",21);
		User user2 = new User("admin2",22);
		User user3 = new User("admin3",23);
		
		Computer c1 = getComputer(user1);//获取第一台电脑配置信息
		Computer c2 = getComputer(user2);//获取第二台电脑配置信息
		Computer c3 = getComputer(user3);//获取第三台电脑配置信息
		
		//序列化对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/work/computer.txt")));
		oos.writeObject(c1);
		oos.writeObject(c2);
		oos.writeObject(c3);
		oos.close();
		
		//反序列化对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src3/day170606/work/computer.txt")));
		Computer c11 = (Computer)ois.readObject();
		System.out.println(c11);
		Computer c22 = (Computer)ois.readObject();
		System.out.println(c22);
		Computer c33 = (Computer)ois.readObject();
		System.out.println(c33);
		
		ois.close();
	}
	
	/**
	 * 通过用户获取电脑信息
	 * @param u
	 * @return
	 */
	private Computer getComputer(User u){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入cpu名称：");
		String cpu = sc.next();
		
		System.out.println("请输入内存名称：");
		String mem = sc.next();
		
		System.out.println("请输入硬盘大小");
		int disk = sc.nextInt();
		
		return new Computer(cpu,mem,disk,u);
	}
}
