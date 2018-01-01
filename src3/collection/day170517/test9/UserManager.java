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
		System.out.println("数据正在加载...");
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
		
		
		//遍历Properties，将Properties对象存入Map集合
		Set<String> keys = p.stringPropertyNames();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			String str = p.getProperty(key);
			User u = strToUser(str);
			map.put(u.getId(), u);
		}
		
		System.out.println("数据加载成功!");
	}
	
	/**
	 * 添加
	 */
	public void addUser(){
		System.out.println("请输入要添加的用户id");
		int id = sc.nextInt();
		
		if(map.containsKey(id)){
			System.out.println("该id已存在");
			return;
		}
		
		System.out.println("请输入要添加的用户名");
		String name = sc.next();
		
		System.out.println("请输入要添加的用户密码");
		String password = sc.next();
		
		User user = new User(id,name,password);
		map.put(id, user);
		System.out.println("添加成功");
	}
	
	private static User strToUser(String str) {
		String[] s = str.split(",");
		return new User(Integer.valueOf(s[0]),s[1],s[2]);
	}

	/**
	 * 删除
	 */
	public void deleteUser(){
		System.out.println("请输入要删除的用户id");
		int id = sc.nextInt();
		
		if(!map.containsKey(id)){
			System.out.println("该id不存在");
			return;
		}
		
		map.remove(id);
		System.out.println("删除成功");
	}
	/**
	 * 修改
	 */
	public void updateUser(){
		System.out.println("请输入要修改的用户id");
		int id = sc.nextInt();
		
		if(!map.containsKey(id)){
			System.out.println("该id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String name = sc.next();
		
		System.out.println("请输入新的用户密码");
		String password = sc.next();
		
		map.get(id).setName(name);
		map.get(id).setPassword(password);
		System.out.println("修改成功");
	}
	/**
	 * 查看单个
	 */
	public void querySingleUser(){
		System.out.println("请输入要查看的用户id");
		int id = sc.nextInt();
		
		if(!map.containsKey(id)){
			System.out.println("该id不存在");
			return;
		}
		
		System.out.println(map.get(id));
	}
	/**
	 * 查看所有
	 */
	public void userList(){
		if(map.size()==0){
			System.out.println("暂时没有任何数据");
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
	 * 存储数据
	 */
	
	public static void storeData(){
		Properties p = new Properties();
		//遍历Map集合，将User存入Properties文件中
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
