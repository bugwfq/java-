package day170324;

import java.util.Scanner;

public class Test {
	

	/**
	 * 记录账号错误登录
	 */
	public static ErrorLoginInfo[] elis = new ErrorLoginInfo[10];
	public static int index = 0;
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.登录2.注册3.退出");
			int mark = sc.nextInt();
			if(mark == ConstantInterface.LOGIN){
				login();//登录
			}else if(mark == ConstantInterface.REGISTER){
				um.addUser();//注册
			}else{
				System.out.println("系统退出");
				break;
			}
		}
	}		
	
	/**
	 * 管理员菜单
	 */
	private static void adminMenu(){
		
		while(true){
			System.out.println("1.班级管理2.学生管理3.报表管理4.用户管理5.返回上一级");
			int mark = sc.nextInt();
		}
	}
	
	/**
	 * 班主任菜单
	 */
	private static void teacherLeaderMenu(){
		while(true){
			System.out.println("1.班级管理2.学生管理3.报表管理4.用户管理5.返回上一级");
			int mark = sc.nextInt();
		}
	}
	
	/**
	 * 任课老师菜单
	 */
	private static void teacherMenu(){
		while(true){
			System.out.println("1.班级管理2.学生管理3.报表管理4.用户管理5.返回上一级");
			int mark = sc.nextInt();
		}
	}
	
	
	
	private static void login(){//登录功能
		System.out.println("请输入用户名");
		String username = sc.next();
		
		User user = Tools.getUserByUsername(username);
		if(user == null){
			System.out.println("非法的账号.");
			return ;
		}
		
		ErrorLoginInfo eli1 = Tools.getErrorLoginInfoByUsername(username);
		if(eli1 != null && eli1.getCount() >= ConstantInterface.ERROR_COUNT){
			System.out.println("你今天登录系统的错误次数超过三次，不允许继续登录.");
			return ;
		}
		
		System.out.println("请输入密码");
		String password = sc.next();
		
		user = Tools.getUserByUnAndPwd(username, password);
		if(user != null){
			System.out.println("登录成功.");
			if(user.getLevel() == ConstantInterface.ADMIN_MENU){
				adminMenu();
			}else if(user.getLevel() == ConstantInterface.TEACHER_LEADER_MENU){
				teacherLeaderMenu();
			}else if(user.getLevel() == ConstantInterface.TEACHER_MENU){
				teacherMenu();
			}
			// 将错误记录表中的记录清零
			ErrorLoginInfo eli = Tools.getErrorLoginInfoByUsername(username);
			if(eli != null){//如果有错误登录记录，又登录成功了，就将错误登录记录清零
				eli.setCount(0);
			}
		}else{
			// 登录失败
			// 1.当前账号在错误登录记录数组没有记录(新增一条记录)
			ErrorLoginInfo eli = Tools.getErrorLoginInfoByUsername(username);
			if(eli == null){
				ErrorLoginInfo newEli = new ErrorLoginInfo(username,1);
				elis[index] = newEli;
				index ++;
			}
			// 2.当前账号在错误登录记录数组有记录(将错误次数+1)
			else{
				eli.setCount(eli.getCount()+1);
			}
			
			System.out.println("登录失败，请重新登录.");
		}
		
	}
}
