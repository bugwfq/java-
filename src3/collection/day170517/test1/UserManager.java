package collection.day170517.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserManager {
	private List<User> userList = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u!=null){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = sc.next();
		
		User user = new User(id,name,password);
		userList.add(user);
		System.out.println("��ӳɹ�");
	}
	
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u==null){
			System.out.println("���û�id������");
			return;
		}
		
		userList.remove(u);
		System.out.println("ɾ���ɹ�");
	}
	
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String name = sc.next();
		
		System.out.println("�������µ��û�����");
		String password = sc.next();
		
		u.setUsername(name);
		u.setPassword(password);
		System.out.println("�޸ĳɹ�");		
	}
	
	private User getUserById(int id){
		for(Iterator<User> iter = userList.iterator();iter.hasNext();){
			User u = iter.next();
			if(u.getId()==id){
				return u;
			}
		}
		return null;
	}
	
	public void querySingleUser(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println(u);
	}
	
	public void userList(){
		if(userList.size()==0){
			System.out.println("û���κ���Ϣ");
			return;
		}
		
		for(Iterator<User> iter = userList.iterator();iter.hasNext();){
			User u = iter.next();
			System.out.println(u);
		}
	}
}
