package collection.test.test3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
	private Scanner sc = new Scanner(System.in);
	
	List<User> userList = new LinkedList<>();
	
	/**
	 * 添加用户
	 */
	public void addUser(){
		System.out.println("请输入要添加的用户id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user!=null){
			System.out.println("该用户id已存在");
			return;
		}
		
		System.out.println("请输入要添加的用户名");
		String name = sc.next();
		
		System.out.println("请输入要添加的用户密码");
		String password = sc.next();
		
		user = new User(id,name,password);
		userList.add(user);
		
		System.out.println("添加成功");
		
	}
	
	/**
	 * 通过用户id获取用户
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
	 * 删除用户
	 */
	public void deleteUser(){
		System.out.println("请输入要删除的用户id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		userList.remove(user);
		System.out.println("删除成功");
	}
	/**
	 * 修改用户信息
	 */
	public void updateUser(){
		System.out.println("请输入要修改的用户id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String name = sc.next();
		
		System.out.println("请输入新的用户密码");
		String password = sc.next();
		
		user.setUsername(name);
		user.setPassword(password);
		
		System.out.println("修改成功");
	}
	
	/**
	 * 查看单个学生信息
	 */
	public void querySingleUser(){
		System.out.println("请输入要查看的用户id");
		int id = sc.nextInt();
		
		User user = getUserById(id);
		if(user==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println(user);
	}
	/**
	 * 查看所有学生信息
	 */
	
	public void userList(){
		if(userList.size()==0){
			System.out.println("暂时没有任何用户信息");
			return;
		}
		
		Iterator<User> iter = userList.iterator();
		while(iter.hasNext()){
			User u = iter.next();
			System.out.println(u);
		}
	}
}
