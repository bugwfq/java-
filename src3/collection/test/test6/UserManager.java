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
		userMap.put(id, user);
		System.out.println("添加成功");
	}
	
	/**
	 * 删除用户
	 */
	
	public void deleteUser(){
		System.out.println("请输入要删除的用户id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("该用户id不存在");
			return;
		}
		
		userMap.remove(id);
		System.out.println("删除成功");
	}
	
	/**
	 * 修改用户信息
	 */
	
	public void updateUser(){
		System.out.println("请输入要修改的用户id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String name = sc.next();
		
		System.out.println("请输入新的用户密码");
		String password = sc.next();
		
		userMap.get(id).setUsername(name);
		userMap.get(id).setPassword(password);
		System.out.println("修改成功");
	}
	
	/**
	 * 查看单个用户信息
	 */
	public void querySingleUser(){
		System.out.println("请输入要查看的用户id");
		int id = sc.nextInt();
		
		if(!userMap.containsKey(id)){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println("该用户信息如下：");
		System.out.println(userMap.get(id));
	}
	
	
	/**
	 * 查看所有用户信息
	 */
	public void userList(){
		if(userMap.size()==0){
			System.out.println("暂时没有任何用户信息");
			return;
		}
		
		System.out.println("所有用户信息如下：");
		Set<Integer> keys = userMap.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer key = iter.next();
			User user = userMap.get(key);
			System.out.println(user);			
		}	
	}
	
}
