package collection.day170504.һ�μ���һ�δ���;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class UserManager {
	
	
	private Scanner sc = new Scanner(System.in);
	private static Map<Integer,User> userMap = new HashMap<>();
	
	static{
		System.out.println("���ݼ����С�����");
		//����Properties����
		Properties p = new Properties();
		
		//��Properties�������Properties�ļ���
		try {
			p.load(new FileInputStream("src3/day170504/һ�μ���һ�δ���/userData.properties"));
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
			String value = p.getProperty(key);
			User user = StringToUser(value);
			userMap.put(Integer.valueOf(user.getId()), user);
		}
		System.out.println("���ݼ�����ɡ�����");
	}
	
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
		userMap.put(id,user);
		System.out.println("��ӳɹ�");
	}
	
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("Ҫɾ�����û�id������");
			return;
		}
		
		userMap.remove(id);
		System.out.println("ɾ���ɹ�");
		
	}
	
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("Ҫ�޸ĵ��û�id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String newName = sc.next();
		
		System.out.println("�������µ��û�����");
		String newPassword = sc.next();
		
		userMap.get(id).setName(newName);
		userMap.get(id).setPassword(newPassword);
		System.out.println("�޸ĳɹ�");
	}
	
	public void querySingleUser(){
		System.out.println("������Ҫ��ѯ���û�id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("Ҫ��ѯ���û�id������");
			return;
		}
		
		Set<Integer> keys = userMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			System.out.println(userMap.get(key));
		}
	}
	
	public void userList(){
		Set<Integer> keys = userMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			User u = userMap.get(key);
			System.out.println(u);
		}
	}
	
	public static User StringToUser(String s){
		String[] ss = s.split(",");
		return new User(Integer.valueOf(ss[0]),ss[1],ss[2]);
	}
	
	public static String UserToString(User user){
		return user.getId()+","+user.getName()+","+user.getPassword();
	}
	
	/**
	 * �����ݴ��浽�ļ���
	 */
	public static void storeData(){
		//����Properties����
		Properties p = new Properties();
		//����Map���ϣ���User����Properties������
		Set<Integer> keys = userMap.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer key = iter.next();
			User user = userMap.get(key);
			String u = UserToString(user);
			//��user����Properties������
			p.setProperty(String.valueOf(key), u);
		}
		
		//��Properties�������properties�ļ���
		try {
			p.store(new FileOutputStream("src3/day170504/һ�μ���һ�δ���/userData.properties"), "all user data");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
