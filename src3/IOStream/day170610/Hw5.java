package IOStream.day170610;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Hw5 {
	/**
	 * 5.定义一个电脑类(Computer),里面有cpu(cpu名称),mem(内存名称),disk(硬盘大小),User(使用者),
	User也是用户自己定义的一个类,里面有name和age两个字段,要求通过系统运行的时候,根据用户选择,
	通过控制台输入三台电脑上述配置,然后序列化到硬盘上面,序列化的时候不需要保存cpu的信息,然后第\二次登录的时候根据用户选项可以从硬盘上面读取这三台电脑的信息,然后打印到控制台.
	考点(序列化 ,反序列化,Scanner,序列化的时候某个字段不需要系列化.序列化要实现的接口( Serializable ),transient 
	 */
	
	
	@Test
	public void test(){
		User u1 = new User("admin1",21);
		User u2 = new User("admin2",22);
		User u3 = new User("admin3",23);
		
		Computer c1 = getComputer(u1);
		Computer c2 = getComputer(u2);
		Computer c3 = getComputer(u3);
		
		List<Computer> list = new ArrayList<>();//将电脑信息存入集合
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170610/computer.txt")));
			oos.writeObject(list);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src3/day170610/computer.txt"));
			try {
				List<Computer> computerList = (List<Computer>)ois.readObject();
				System.out.println("所有电脑信息："+computerList);
			} catch (ClassNotFoundException e) {
				System.out.println("类型转换异常");
			}
			ois.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		} catch (IOException e) {
			System.out.println("IO读写异常");
		}
		
	}
	
	
	

	private Computer getComputer(User u) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入CPU名称");
		String cpu = sc.next();
		
		System.out.println("请输入内存名称");
		String mem = sc.next();
		
		System.out.println("请输入硬盘大小");
		int disk = sc.nextInt();
		
		return new Computer(cpu,mem,disk,u);
	}
	
	
}
