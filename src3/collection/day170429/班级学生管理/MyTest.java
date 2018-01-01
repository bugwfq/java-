package collection.day170429.班级学生管理;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class MyTest {
	private static Map<String,User> userMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	
	//声明一个Map集合用来存储错误用户次数
	private static Map<String,Integer> errorMap = new HashMap<>();
	
	static{
		User adminUser = new User("1","admin","admin",1);
		User commonUser = new User("2","common","common",2);
		
		userMap.put(adminUser.getId(), adminUser);
		userMap.put(commonUser.getId(), commonUser);
		System.out.println("初始化完成。。。");
	}
	
	@Test
	public void test1(){
		while(true){
			System.out.println("1.登录2.退出");
			int mark = sc.nextInt();
			if(mark==1){
				login();
			}else{
				System.exit(0);
			}
		}
	}
	
	public void login(){
		System.out.println("请输入用户名");
		String name = sc.next();
		
		User user = getUserByName(name);
		if(user==null){
			System.out.println("该用户名不存在");
			return;
		}
		
		//通过用户名获取登录错误次数
		Integer temp = errorMap.get(name);
		if(temp!=null && temp>=3){
			System.out.println("登录错误3次，该账号已冻结");
			return;
		}
		
		System.out.println("请输入密码");
		String password = sc.next();
		
		if(user.getPassword().equals(password)){
			System.out.println("登录成功");
			errorMap.remove(name);
			if(user.getType()==1){
				adminMenu();
			}else{
				commonMenu();
			}
				
		}else{			
			System.out.println("登录失败");
			if(temp==null){//错误一次
				errorMap.put(name, 1);
			}else{//错误两次以上
				errorMap.put(name, temp+1);
			}
		}
			
		
	}
	
	/**
	 * 通过用户名获取用户
	 */
	public User getUserByName(String name){
		Set<String> keys = userMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			User u = userMap.get(key);
			if(u.getName().equals(name)){
				return u;
			}		
		}
		return null;
	}
	
	ClassesManager cm = new ClassesManager();
	StudentManager sm = new StudentManager();
	
	/**
	 * 管理员菜单
	 */	
	public void adminMenu(){
		while(true){
			System.out.println("1.班级管理2.学生管理0.退出");
			int mark = sc.nextInt();
			if(mark==1){
				while(true){
					System.out.println("1.增加班级2.删除班级3.修改班级4.查看单个班级5.查看所有班级信息0.返回上一级");
					int mark1 = sc.nextInt();
					if(mark1==1){
						cm.addClasses();
					}else if(mark1==2){
						cm.deleteClasses();
					}else if(mark1==3){
						cm.updateClasses();
					}else if(mark1==4){
						cm.querySingleClasses();
					}else if(mark1==5){
						cm.ClassesList();
					}else {
						break;
					}
				
				}
			}else if(mark==2){
				while(true){
					System.out.println("1.增加学生2.删除学生3.修改学生4.查看单个学生5.查看所有学生信息0.返回上一级");
					int mark2 = sc.nextInt();
					if(mark2==1){
						sm.addStudent();
					}else if(mark2==2){
						sm.deleteStudent();
					}else if(mark2==3){
						sm.updateStudent();
					}else if(mark2==4){
						sm.querySingleStudent();
					}else if(mark2==5){
						sm.studentList();
					}else {
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
	public void commonMenu(){	
		while(true){
			System.out.println("1.班级管理2.学生管理0.退出");
			int mark = sc.nextInt();
			if(mark==1){
				while(true){
					System.out.println("1.查看单个班级2.查看所有班级信息0.返回上一级");
					int mark1 = sc.nextInt();
					if(mark1==1){						
						cm.querySingleClasses();
					}else if(mark1==2){
						cm.ClassesList();
					}else {
						break;
					}				
				}
			}else if(mark==2){
				while(true){
					System.out.println("1.查看单个学生2.查看所有学生信息0.返回上一级");
					int mark2 = sc.nextInt();
					if(mark2==1){				
						sm.querySingleStudent();
					}else if(mark2==2){
						sm.studentList();
					}else {
						break;
					}				
				}
			}else{
				break;
			}
			
		}
	}
	
	
	/**
	 * 通过用户名和用户密码获取用户
	 */
	
	/*private User getUserByName(String name,String password){
		Set<String> keys = userMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			User u = userMap.get(key);
			if(u.getName().equals(name) && u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}*/
}
