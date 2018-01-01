package collection.day170504.一次加载一次储存;

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
		System.out.println("数据加载中。。。");
		//创建Properties对象
		Properties p = new Properties();
		
		//将Properties对象读入Properties文件里
		try {
			p.load(new FileInputStream("src3/day170504/一次加载一次储存/userData.properties"));
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
			String value = p.getProperty(key);
			User user = StringToUser(value);
			userMap.put(Integer.valueOf(user.getId()), user);
		}
		System.out.println("数据加载完成。。。");
	}
	
	/**
	 * 添加用户
	 */
	
	public void addUser(){
		System.out.println("请输入要添加的用户id");
		int id = sc.nextInt();
		
		if(userMap.containsKey(id)){
			System.out.println("该用户id已存在");
			return;
		}
		
		System.out.println("请输入要添加的用户名");
		String name = sc.next();
		
		System.out.println("请输入要添加的用户密码");
		String password = sc.next();
		
		User user = new User(id,name,password);
		userMap.put(id,user);
		System.out.println("添加成功");
	}
	
	public void deleteUser(){
		System.out.println("请输入要删除的用户id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("要删除的用户id不存在");
			return;
		}
		
		userMap.remove(id);
		System.out.println("删除成功");
		
	}
	
	public void updateUser(){
		System.out.println("请输入要修改的用户id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("要修改的用户id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String newName = sc.next();
		
		System.out.println("请输入新的用户密码");
		String newPassword = sc.next();
		
		userMap.get(id).setName(newName);
		userMap.get(id).setPassword(newPassword);
		System.out.println("修改成功");
	}
	
	public void querySingleUser(){
		System.out.println("请输入要查询的用户id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("要查询的用户id不存在");
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
	 * 将数据储存到文件中
	 */
	public static void storeData(){
		//创建Properties对象
		Properties p = new Properties();
		//遍历Map集合，将User存入Properties对象中
		Set<Integer> keys = userMap.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer key = iter.next();
			User user = userMap.get(key);
			String u = UserToString(user);
			//将user存入Properties对象中
			p.setProperty(String.valueOf(key), u);
		}
		
		//将Properties对象存入properties文件里
		try {
			p.store(new FileOutputStream("src3/day170504/一次加载一次储存/userData.properties"), "all user data");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
