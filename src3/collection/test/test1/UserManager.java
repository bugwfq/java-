package collection.test.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserManager {
	private List<User> userList = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ����û�
	 */
	
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user != null){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("�������û���");
		String name = sc.next();
		
		System.out.println("�������û�����");
		String password = sc.next();
		
		User newUser = new User(id,name,password);
		userList.add(newUser);
		System.out.println("��ӳɹ�");		
	}
	
	/**
	 * ͨ���û�id��ȡ�û�
	 */

	private User getUserById(int id){
		Iterator<User> iter = userList.iterator();
		while(iter.hasNext()){
			User user = iter.next();			
			if(user.getId()==id){
				return user;
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
		if(user == null){
			System.out.println("���û�id������");
			return;
		}
		
		userList.remove(user);
		System.out.println("ɾ���ɹ�");
	}
	/**
	 * �޸��û�
	 */
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user == null){
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
	 * �鿴�����û�
	 */
	public void querySingleUser(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user == null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println(user);
	}
	
	/**
	 * �鿴�����û�
	 */
	public void userList(){
		if(userList.size()==0){
			System.out.println("��ǰû���κ��û���Ϣ");
			return;
		}
		
		Iterator<User> iter = userList.iterator();
		while(iter.hasNext()){
			User user = iter.next();
			System.out.println(user);
		}
	}
	
}
