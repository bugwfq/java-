package day170324;

import java.util.Scanner;

public class UserManager {

	
	public static User[] users = new User[10];
	public static int index = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 增加用户
	 */
	public void addUser(){//用户注册
	
		System.out.println("请输入用户id");
		int id = sc.nextInt();
		
		User user = Tools.getUserById(id);
		if(user != null){
			System.out.println("该用户id已存在.");
			return ;
		}
		
		System.out.println("请输入用户名");
		String username = sc.next();
		user = Tools.getUserByUsername(username);
		if(user != null){
			System.out.println("该用户名已注册.");
			return ;
		}
		
		System.out.println("请输入用户密码");
		String password = sc.next();
		
		System.out.println("请选择用户等级:1.管理员2.班主任3.任课老师");
		int level = sc.nextInt();
		
		User newUser = new User(id, username, password, level);
		users[index] = newUser;
		index ++;
		System.out.println("用户注册成功.");
	}
	
	/**
	 * 用户列表
	 */
	public void userList(){
		System.out.println("所有用户信息如下:");
		for(int i = 0;i<index;i++){
			System.out.println(users[i]);
		}
	}
}
