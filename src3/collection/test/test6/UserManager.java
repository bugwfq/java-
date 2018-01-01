package collection.test.test6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserManager {
	private Scanner sc = new Scanner(System.in);
	private Map<Integer, User> userMap = new HashMap<>();
	
	/**
	 * ����û�
	 */
	
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�id");
		int id = sc.nextInt();
		
		if(userMap.containsKey(id)){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = sc.next();
		
		User user = new User(id,name,password);
		userMap.put(id, user);
		System.out.println("��ӳɹ�");
	}
	
	/**
	 * ɾ���û�
	 */
	
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("���û�id������");
			return;
		}
		
		userMap.remove(id);
		System.out.println("ɾ���ɹ�");
	}
	
	/**
	 * �޸��û���Ϣ
	 */
	
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String name = sc.next();
		
		System.out.println("�������µ��û�����");
		String password = sc.next();
		
		userMap.get(id).setUsername(name);
		userMap.get(id).setPassword(password);
		System.out.println("�޸ĳɹ�");
	}
	
	/**
	 * �鿴�����û���Ϣ
	 */
	public void querySingleUser(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("���û���Ϣ���£�");
		System.out.println(userMap.get(id));
	}
	
	
	/**
	 * �鿴�����û���Ϣ
	 */
	public void userList(){
		if(userMap.size()==0){
			System.out.println("��ʱû���κ��û���Ϣ");
			return;
		}
		
		System.out.println("�����û���Ϣ���£�");
		Set<Integer> keys = userMap.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer key = iter.next();
			User user = userMap.get(key);
			System.out.println(user);			
		}	
	}
	
}
