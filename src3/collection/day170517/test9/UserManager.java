package collection.day170517.test9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class UserManager {
	private static Map<Integer,User> map = new HashMap<>();
	private Scanner sc = new Scanner(System.in);
	
	static{
		System.out.println("�������ڼ���...");
		Properties p = new Properties();
		
		
			try {
				p.load(new FileInputStream("src3/day170517/test9/userData.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		//����Properties����Properties�������Map����
		Set<String> keys = p.stringPropertyNames();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			String str = p.getProperty(key);
			User u = strToUser(str);
			map.put(u.getId(), u);
		}
		
		System.out.println("���ݼ��سɹ�!");
	}
	
	/**
	 * ���
	 */
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�id");
		int id = sc.nextInt();
		
		if(map.containsKey(id)){
			System.out.println("��id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = sc.next();
		
		User user = new User(id,name,password);
		map.put(id, user);
		System.out.println("��ӳɹ�");
	}
	
	private static User strToUser(String str) {
		String[] s = str.split(",");
		return new User(Integer.valueOf(s[0]),s[1],s[2]);
	}

	/**
	 * ɾ��
	 */
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		if(!map.containsKey(id)){
			System.out.println("��id������");
			return;
		}
		
		map.remove(id);
		System.out.println("ɾ���ɹ�");
	}
	/**
	 * �޸�
	 */
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		if(!map.containsKey(id)){
			System.out.println("��id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String name = sc.next();
		
		System.out.println("�������µ��û�����");
		String password = sc.next();
		
		map.get(id).setName(name);
		map.get(id).setPassword(password);
		System.out.println("�޸ĳɹ�");
	}
	/**
	 * �鿴����
	 */
	public void querySingleUser(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		if(!map.containsKey(id)){
			System.out.println("��id������");
			return;
		}
		
		System.out.println(map.get(id));
	}
	/**
	 * �鿴����
	 */
	public void userList(){
		if(map.size()==0){
			System.out.println("��ʱû���κ�����");
			return;
		}
		
		Set<Integer> keys = map.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer key = iter.next();
			User u = map.get(key);
			System.out.println(u);
		}
	}
	
	/**
	 * �洢����
	 */
	
	public static void storeData(){
		Properties p = new Properties();
		//����Map���ϣ���User����Properties�ļ���
		Set<Integer> keys = map.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer key = iter.next();
			User u = map.get(key);
			String s = userToStr(u);
			p.setProperty(String.valueOf(u.getId()), s);
		}
		
		try {
			p.store(new FileOutputStream("src3/day170517/test9/userData.properties"),"all user list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String userToStr(User u) {		
		return u.getId()+","+u.getName()+","+u.getPassword();
	}
}
