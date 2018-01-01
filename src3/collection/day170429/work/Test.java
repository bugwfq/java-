package collection.day170429.work;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {

	private static Map<String,User> userMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 当该用户错误三次，在程序结束之前不能继续登录
	 */
	
	private static Map<String,Integer> errorMap = new HashMap<>();
	
	/**
	 * 
	 * 
	 * admin 2
	 * cc 1
	 */
	
	static {
		/*
		 * admin:所有权限
		 * cc:查询权限 
		 */
		
		User adminUser = new User("1", "admin", "admin", 1);
		User commonUser = new User("2", "cc", "cc", 2);
		
		userMap.put(adminUser.getId(), adminUser);
		userMap.put(commonUser.getId(), commonUser);
		System.out.println("数据初始化完成...");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		while(true){
			System.out.println("1.登录2.退出");
			int mark = sc.nextInt();
			
			if(mark == 1){
				login();
			}else{
				System.exit(0);
			}
		}
	
		
		
	}

	private static void login() throws FileNotFoundException, IOException {
		System.out.println("请输入用户名");
		String username = sc.next();
		
		if(errorMap.containsKey(username) && errorMap.get(username)>=3){
			System.out.println("当前用户登录已经错误3次，今天不能登录");
			return ;
		}
		
		
		System.out.println("请输入密码");
		String password = sc.next();
		
		User loginUser = getUserByUnAndPwd(username, password);
		if(loginUser != null){
			
			// 需要对登录错误次数清0
			if(errorMap.containsKey(username)){
				errorMap.remove(username);
//				errorMap.put(username, 0);
			}
			
			if(loginUser.getType() == 1){
				adminMenu();
			}else{
				commonMenu();
			}
			
		}else{
			System.out.println("用户名密码错误，登录失败.");
			
			// 将合法的用户名记录下来(admin,cc) dd
			if(getUserByUsername(username)!=null){
				
				// 将这个用户信息保存errorMap里(1.第一次错误；2.第二次以上)
				if(errorMap.containsKey(username)){ // 说明今天已经保存了错误次数
					errorMap.put(username, errorMap.get(username)+1);
				}else{
					errorMap.put(username, 1);
				}
			}
			
			
		}
	}
	
	private static User getUserByUsername(String username){
		
		Set<String> keys = userMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			User user = userMap.get(key);
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		
		return null;
	}
	
	private static User getUserByUnAndPwd(String username,String password){
		
		Set<String> keys = userMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			User user = userMap.get(key);
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		
		return null;
	}
	private static ClassesManager cm = new ClassesManager();
	private static StudentManager sm = new StudentManager();
	/**
	 * 管理员菜单
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void adminMenu() throws FileNotFoundException, IOException{
		
		
		while(true){
			System.out.println("1.班级管理2.学生管理3.退出");
			int mark = sc.nextInt();	
			
			if(mark == 1){
				
				while(true){
					System.out.println("1.增加班级2.删除班级3.查询班级4.修改班级5.班级列表6.返回上一级");
					int mark1 = sc.nextInt();
					
					if(mark1 == 1){
						cm.addClasses();
					}else if(mark1 == 2){
						cm.deleteClasses();
					}else if(mark1 == 3){
						cm.querySingleClasses();
					}else if(mark1 == 4){
						cm.updateClasses();
					}else if(mark1 == 5){
						cm.classesList();
					}else{
						break;
					}
					
				}
			}else if(mark == 2){
				while(true){
					System.out.println("1.增加学生2.删除学生3.查询学生4.学生列表5.修改学生6.返回上一级");
					int mark1 = sc.nextInt();
						
					if(mark1 == 1){
						sm.addStudent();
					}else if(mark1 == 2){
						sm.deleteStudent();
					}else if(mark1 == 3){
						sm.querySingleStudent();
					}else if(mark1 == 4){
						sm.studentList();
					}else if(mark1 == 5){
						sm.udpateStudent();
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
	}
	
	/**
	 * 普通用户菜单
	 */
	public static void commonMenu(){
		while(true){
			System.out.println("1.班级管理2.学生管理3.退出");
			int mark = sc.nextInt();
			
			if(mark == 1){
				while(true){
					System.out.println("1.查看班级2.班级列表3.返回上一级");
					int mark1 = sc.nextInt();
						
					if(mark1 == 1){
						cm.querySingleClasses();
					}else if(mark1 == 2){
						cm.classesList();
					}else{
						break;
					}
				}
				
			}else if(mark == 2){
				while(true){
					System.out.println("1.查看学生2.学生列表3.返回上一级");
					int mark1 = sc.nextInt();
					
					if(mark1 == 1){
						sm.querySingleStudent();
					}else if(mark1 == 2){
						sm.studentList();
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
	}
}
