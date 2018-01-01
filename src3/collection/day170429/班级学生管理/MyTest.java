package collection.day170429.�༶ѧ������;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class MyTest {
	private static Map<String,User> userMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	
	//����һ��Map���������洢�����û�����
	private static Map<String,Integer> errorMap = new HashMap<>();
	
	static{
		User adminUser = new User("1","admin","admin",1);
		User commonUser = new User("2","common","common",2);
		
		userMap.put(adminUser.getId(), adminUser);
		userMap.put(commonUser.getId(), commonUser);
		System.out.println("��ʼ����ɡ�����");
	}
	
	@Test
	public void test1(){
		while(true){
			System.out.println("1.��¼2.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				login();
			}else{
				System.exit(0);
			}
		}
	}
	
	public void login(){
		System.out.println("�������û���");
		String name = sc.next();
		
		User user = getUserByName(name);
		if(user==null){
			System.out.println("���û���������");
			return;
		}
		
		//ͨ���û�����ȡ��¼�������
		Integer temp = errorMap.get(name);
		if(temp!=null && temp>=3){
			System.out.println("��¼����3�Σ����˺��Ѷ���");
			return;
		}
		
		System.out.println("����������");
		String password = sc.next();
		
		if(user.getPassword().equals(password)){
			System.out.println("��¼�ɹ�");
			errorMap.remove(name);
			if(user.getType()==1){
				adminMenu();
			}else{
				commonMenu();
			}
				
		}else{			
			System.out.println("��¼ʧ��");
			if(temp==null){//����һ��
				errorMap.put(name, 1);
			}else{//������������
				errorMap.put(name, temp+1);
			}
		}
			
		
	}
	
	/**
	 * ͨ���û�����ȡ�û�
	 */
	public User getUserByName(String name){
		Set<String> keys = userMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			User u = userMap.get(key);
			if(u.getName().equals(name)){
				return u;
			}		
		}
		return null;
	}
	
	ClassesManager cm = new ClassesManager();
	StudentManager sm = new StudentManager();
	
	/**
	 * ����Ա�˵�
	 */	
	public void adminMenu(){
		while(true){
			System.out.println("1.�༶����2.ѧ������0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				while(true){
					System.out.println("1.���Ӱ༶2.ɾ���༶3.�޸İ༶4.�鿴�����༶5.�鿴���а༶��Ϣ0.������һ��");
					int mark1 = sc.nextInt();
					if(mark1==1){
						cm.addClasses();
					}else if(mark1==2){
						cm.deleteClasses();
					}else if(mark1==3){
						cm.updateClasses();
					}else if(mark1==4){
						cm.querySingleClasses();
					}else if(mark1==5){
						cm.ClassesList();
					}else {
						break;
					}
				
				}
			}else if(mark==2){
				while(true){
					System.out.println("1.����ѧ��2.ɾ��ѧ��3.�޸�ѧ��4.�鿴����ѧ��5.�鿴����ѧ����Ϣ0.������һ��");
					int mark2 = sc.nextInt();
					if(mark2==1){
						sm.addStudent();
					}else if(mark2==2){
						sm.deleteStudent();
					}else if(mark2==3){
						sm.updateStudent();
					}else if(mark2==4){
						sm.querySingleStudent();
					}else if(mark2==5){
						sm.studentList();
					}else {
						break;
					}
				
				}
			}else{
				break;
			}
			
		}
	}
	
	/**
	 * ��ͨ�û��˵�
	 */
	public void commonMenu(){	
		while(true){
			System.out.println("1.�༶����2.ѧ������0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				while(true){
					System.out.println("1.�鿴�����༶2.�鿴���а༶��Ϣ0.������һ��");
					int mark1 = sc.nextInt();
					if(mark1==1){						
						cm.querySingleClasses();
					}else if(mark1==2){
						cm.ClassesList();
					}else {
						break;
					}				
				}
			}else if(mark==2){
				while(true){
					System.out.println("1.�鿴����ѧ��2.�鿴����ѧ����Ϣ0.������һ��");
					int mark2 = sc.nextInt();
					if(mark2==1){				
						sm.querySingleStudent();
					}else if(mark2==2){
						sm.studentList();
					}else {
						break;
					}				
				}
			}else{
				break;
			}
			
		}
	}
	
	
	/**
	 * ͨ���û������û������ȡ�û�
	 */
	
	/*private User getUserByName(String name,String password){
		Set<String> keys = userMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			User u = userMap.get(key);
			if(u.getName().equals(name) && u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}*/
}
