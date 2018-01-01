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
		 * 5.����һ��������(Computer),������cpu(cpu����),mem(�ڴ�����),disk(Ӳ�̴�С),User(ʹ����),
		 * UserҲ���û��Լ������һ����,������name��age�����ֶ�,Ҫ��ͨ��ϵͳ���е�ʱ��,�����û�ѡ��,
		 * ͨ������̨������̨������������,Ȼ�����л���Ӳ������,���л���ʱ����Ҫ����cpu����Ϣ,
		 * Ȼ���\���ε�¼��ʱ������û�ѡ����Դ�Ӳ�������ȡ����̨���Ե���Ϣ,Ȼ���ӡ������̨.
		 * ����(���л� ,�����л�,Scanner,���л���ʱ��ĳ���ֶβ���Ҫϵ�л�.
		 * ���л�Ҫʵ�ֵĽӿ�( Serializable ),transient
		 */
		
		User user1 = new User("admin1",21);
		User user2 = new User("admin2",22);
		User user3 = new User("admin3",23);
		
		Computer c1 = getComputer(user1);//��ȡ��һ̨����������Ϣ
		Computer c2 = getComputer(user2);//��ȡ�ڶ�̨����������Ϣ
		Computer c3 = getComputer(user3);//��ȡ����̨����������Ϣ
		
		//���л�����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src3/day170606/work/computer.txt")));
		oos.writeObject(c1);
		oos.writeObject(c2);
		oos.writeObject(c3);
		oos.close();
		
		//�����л�����
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
	 * ͨ���û���ȡ������Ϣ
	 * @param u
	 * @return
	 */
	private Computer getComputer(User u){
		Scanner sc = new Scanner(System.in);
		System.out.println("������cpu���ƣ�");
		String cpu = sc.next();
		
		System.out.println("�������ڴ����ƣ�");
		String mem = sc.next();
		
		System.out.println("������Ӳ�̴�С");
		int disk = sc.nextInt();
		
		return new Computer(cpu,mem,disk,u);
	}
}
