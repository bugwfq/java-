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
	 * 5.����һ��������(Computer),������cpu(cpu����),mem(�ڴ�����),disk(Ӳ�̴�С),User(ʹ����),
	UserҲ���û��Լ������һ����,������name��age�����ֶ�,Ҫ��ͨ��ϵͳ���е�ʱ��,�����û�ѡ��,
	ͨ������̨������̨������������,Ȼ�����л���Ӳ������,���л���ʱ����Ҫ����cpu����Ϣ,Ȼ���\���ε�¼��ʱ������û�ѡ����Դ�Ӳ�������ȡ����̨���Ե���Ϣ,Ȼ���ӡ������̨.
	����(���л� ,�����л�,Scanner,���л���ʱ��ĳ���ֶβ���Ҫϵ�л�.���л�Ҫʵ�ֵĽӿ�( Serializable ),transient 
	 */
	
	
	@Test
	public void test(){
		User u1 = new User("admin1",21);
		User u2 = new User("admin2",22);
		User u3 = new User("admin3",23);
		
		Computer c1 = getComputer(u1);
		Computer c2 = getComputer(u2);
		Computer c3 = getComputer(u3);
		
		List<Computer> list = new ArrayList<>();//��������Ϣ���뼯��
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
				System.out.println("���е�����Ϣ��"+computerList);
			} catch (ClassNotFoundException e) {
				System.out.println("����ת���쳣");
			}
			ois.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		} catch (IOException e) {
			System.out.println("IO��д�쳣");
		}
		
	}
	
	
	

	private Computer getComputer(User u) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������CPU����");
		String cpu = sc.next();
		
		System.out.println("�������ڴ�����");
		String mem = sc.next();
		
		System.out.println("������Ӳ�̴�С");
		int disk = sc.nextInt();
		
		return new Computer(cpu,mem,disk,u);
	}
	
	
}
