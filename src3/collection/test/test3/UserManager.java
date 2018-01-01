package collection.test.test3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
	private Scanner sc = new Scanner(System.in);
	
	List<User> userList = new LinkedList<>();
	
	/**
	 * ����û�
	 */
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user!=null){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = sc.next();
		
		user = new User(id,name,password);
		userList.add(user);
		
		System.out.println("��ӳɹ�");
		
	}
	
	/**
	 * ͨ���û�id��ȡ�û�
	 */
	private User getUserById(int id){
		Iterator<User> iter = userList.iterator();
		while(iter.hasNext()){
			User u = iter.next();
			if(u.getId()==id){
				return u;
			}
		}
		return null;
	}
	
	/**
	 * ɾ���û�
	 */
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user==null){
			System.out.println("���û�id������");
			return;
		}
		
		userList.remove(user);
		System.out.println("ɾ���ɹ�");
	}
	/**
	 * �޸��û���Ϣ
	 */
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String name = sc.next();
		
		System.out.println("�������µ��û�����");
		String password = sc.next();
		
		user.setUsername(name);
		user.setPassword(password);
		
		System.out.println("�޸ĳɹ�");
	}
	
	/**
	 * �鿴����ѧ����Ϣ
	 */
	public void querySingleUser(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println(user);
	}
	/**
	 * �鿴����ѧ����Ϣ
	 */
	
	public void userList(){
		if(userList.size()==0){
			System.out.println("��ʱû���κ��û���Ϣ");
			return;
		}
		
		Iterator<User> iter = userList.iterator();
		while(iter.hasNext()){
			User u = iter.next();
			System.out.println(u);
		}
	}
}
