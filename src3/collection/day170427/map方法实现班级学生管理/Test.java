package collection.day170427.map方法实现班级学生管理;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
	
	private static Scanner sc = new Scanner(System.in);
	private static ClassesManager cm = new ClassesManager();
	private static StudentManager sm = new StudentManager();
	private static ReportManager rm = new ReportManager();
	
	private static Map<Integer, User> userMap = new HashMap<>();
	private static Map<String,Integer> errorMap = new HashMap<>();
	
	static {
		User admin = new User(1,"1","1",1);
		User common = new User(2,"2","2",2);
		userMap.put(admin.getId(), admin);
		userMap.put(common.getId(), common);
	}
	
	public static void main(String[] args) {
		while(true){
			System.out.println("1.登录2.注册0.退出");
			int mark = sc.nextInt();
			if(mark==ConstantInterface.LOGIN){
				login();
			}else if(mark==ConstantInterface.ADDUSER){
				addUser();
			}else {
				System.exit(ConstantInterface.EXIT);
			}
		}
	}
	
	/**
	 * 用户注册
	 */
	
	public static void addUser(){
		System.out.println("请输入要注册的用户id");
		int id =sc.nextInt();
		
		if(userMap.containsKey(id)==true){
			System.out.println("该用户id已存在");
			return;
		}
		
		System.out.println("请输入要注册的用户名");
		String userName = sc.next();
		if(getUserByName(userName)!=null){
			System.out.println("该用户名已注册");
			return;
		}
		
		System.out.println("请输入要注册的用户密码");
		String password = sc.next();
		
		System.out.println("请选择要注册的用户等级:1.管理员2.普通用户");
		int type = sc.nextInt();
		User user = new User(id,userName,password,type);
		userMap.put(id, user);
		System.out.println("注册成功！");
	}
	
	/**
	 * 登录
	 */
	
	public static void login(){
		System.out.println("请输入用户名");
		String userName = sc.next();
		
		if(errorMap.containsKey(userName) && errorMap.get(userName)>=3){
			System.out.println("当前用户登录已经错误3次，今天不能登录");
			return;
		}
		
		System.out.println("请输入用户密码");
		String password = sc.next();
		
		User user = getUserByUnAndPw(userName,password);
		if(user != null){
			
			// 需要对登录错误次数清0
			if(errorMap.containsKey(userName)){
				errorMap.remove(userName);
//				errorMap.put(userName, 0);
			}
			
			if(user.getType()==ConstantInterface.ADMINMENU){
				adminMenu();
			}else{
				commonMenu();
			}
			
		}else{
			System.out.println("用户名密码错误，登录失败.");
			
			// 将合法的用户名记录下来(admin,cc) dd
			if(getUserByName(userName)!=null){
				
				// 将这个用户信息保存errorMap里(1.第一次错误；2.第二次以上)
				if(errorMap.containsKey(userName)){ // 说明今天已经保存了错误次数
					errorMap.put(userName, errorMap.get(userName)+1);
				}else{
					errorMap.put(userName, 1);
				}
			}
		}
	}
	
	/**
	 * 通过用户名或取用户
	 */
	
	public static User getUserByName(String userName){
		Set<Integer> keys = userMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			User user = userMap.get(key);
			if(user.getName().equals(userName)){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * 通过用户名与密码获取用户
	 */
	
	public static User getUserByUnAndPw(String userName,String password){
		Set<Integer> keys = userMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			User user = userMap.get(key);
			if(user.getName().equals(userName) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * 管理员菜单
	 */
	public static void adminMenu(){
		while(true){
			System.out.println("1.班级管理2.学生管理3.报表中心0.退出");
			int mark = sc.nextInt();
			if(mark==ConstantInterface.CLASSESMANAGER){
				while(true){
					System.out.println("1.添加班级2.删除班级3.修改班级信息4.查看单个班级信息5.查看班级信息0.返回上一级");
					int mark1 = sc.nextInt();
					if(mark1==ConstantInterface.ADMIN_ADD_CLASSES){
						cm.addClasses();
					}else if(mark1==ConstantInterface.ADMIN_DELETE_CLASSES){
						cm.deleteClasses();
					}else if(mark1==ConstantInterface.ADMIN_UPDATE_CLASSES){
						cm.updateClasses();
					}else if(mark1==ConstantInterface.ADMIN_QUERY_SINGLE_CLASSES){
						cm.querySingleClasses();
					}else if(mark1==ConstantInterface.ADMIN_CLASSES_LIST){
						cm.ClassesList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.STUDENTMANAGER){
				while(true){
					System.out.println("1.添加学生2.删除学生3.修改学生信息4.查看单个学生信息5.查看学生信息0.返回上一级");
					int mark2 = sc.nextInt();
					if(mark2==ConstantInterface.ADMIN_ADD_STUDENT){
						sm.addStudent();
					}else if(mark2==ConstantInterface.ADMIN_DELETE_STUDENT){
						sm.deleteStudent();
					}else if(mark2==ConstantInterface.ADMIN_UPDATE_STUDENT){
						sm.updateStudent();
					}else if(mark2==ConstantInterface.ADMIN_QUERY_SINGLE_STUDENT){
						sm.querySingleStudent();
					}else if(mark2==ConstantInterface.ADMIN_STUDENT_LIST){
						sm.studentList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.REPORTMANAGER){
				while(true){
					System.out.println("1.查看某个班级底下的男女生数2.查看某班级地下的最大年龄，最小年龄，平均年龄3.统计全校男女生数4.查看全校最大的年龄的学生，最小年龄的学生0.返回上一级");
					int mark3 = sc.nextInt();
					if(mark3==ConstantInterface.QUERYBOYSANDGIRLSBYCLSID){
						System.out.println("请输入要查看的班级id");
						int clsId = sc.nextInt();
						rm.queryBoysAndGirlsByClsId(clsId);
					}else if(mark3==ConstantInterface.QUERYMAXAGEVSMINAGEVSAVERAGEAGE){
						System.out.println("请输入要查看的班级id");
						int clsId = sc.nextInt();
						rm.queryMaxAgeVsMinAgeVsAverageAge(clsId);
					}else if(mark3==ConstantInterface.QUERYALLBOYSANDGIRLS){
						rm.queryAllBoysAndGirls();
					}else if(mark3==ConstantInterface.QUERYMAXAGESTUANDMINAGESTU){
						rm.queryMaxAgeStuAndMinAgeStu();
					}else{
						break;
					}
				}	
			}else{
				System.exit(ConstantInterface.EXIT);
			}
		}
	}
	
	
	
	/**
	 *普通用户菜单 
	 */
	public static void commonMenu(){
		while(true){
			System.out.println("1.班级管理2.学生管理3.报表中心0.退出");
			int mark = sc.nextInt();
			if(mark==ConstantInterface.CLASSESMANAGER){
				while(true){
					System.out.println("1.查看单个班级信息2.查看所有班级信息0.返回上一级");
					int mark1 = sc.nextInt();
					if(mark1==ConstantInterface.COMMON_QUERY_SINGLE_CLASSES){
						cm.querySingleClasses();
					}else if(mark1==ConstantInterface.COMMON_CLASSES_LIST){
						cm.ClassesList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.STUDENTMANAGER){
				while(true){
					System.out.println("1.查看单个学生信息2.查看所有学生信息0.返回上一级");
					int mark2 = sc.nextInt();
					if(mark2==ConstantInterface.COMMON_QUERY_SINGLE_STUDENT){
						sm.querySingleStudent();
					}else if(mark2==ConstantInterface.COMMON_STUDENT_LIST){
						sm.studentList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.REPORTMANAGER){
				while(true){
					System.out.println("1.查看某个班级底下的男女生数2.查看某班级地下的最大年龄，最小年龄，平均年龄3.统计全校男女生数4.查看全校最大的年龄的学生，最小年龄的学生0.返回上一级");
					int mark3 = sc.nextInt();
					if(mark3==ConstantInterface.QUERYBOYSANDGIRLSBYCLSID){
						System.out.println("请输入要查看的班级id");
						int clsId = sc.nextInt();
						rm.queryBoysAndGirlsByClsId(clsId);
					}else if(mark3==ConstantInterface.QUERYMAXAGEVSMINAGEVSAVERAGEAGE){
						System.out.println("请输入要查看的班级id");
						int clsId = sc.nextInt();
						rm.queryMaxAgeVsMinAgeVsAverageAge(clsId);
					}else if(mark3==ConstantInterface.QUERYALLBOYSANDGIRLS){
						rm.queryAllBoysAndGirls();
					}else if(mark3==ConstantInterface.QUERYMAXAGESTUANDMINAGESTU){
						rm.queryMaxAgeStuAndMinAgeStu();
					}else{
						break;
					}
				}	
			}else{
				System.exit(ConstantInterface.EXIT);
			}
		}
	}
}
