package collection.day170517.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserManager {
	private List<User> userList = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public void addUser(){
		System.out.println("请输入要添加的用户id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u!=null){
			System.out.println("该用户id已存在");
			return;
		}
		
		System.out.println("请输入要添加的用户名");
		String name = sc.next();
		
		System.out.println("请输入要添加的用户密码");
		String password = sc.next();
		
		User user = new User(id,name,password);
		userList.add(user);
		System.out.println("添加成功");
	}
	
	public void deleteUser(){
		System.out.println("请输入要删除的用户id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		userList.remove(u);
		System.out.println("删除成功");
	}
	
	public void updateUser(){
		System.out.println("请输入要修改的用户id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String name = sc.next();
		
		System.out.println("请输入新的用户密码");
		String password = sc.next();
		
		u.setUsername(name);
		u.setPassword(password);
		System.out.println("修改成功");		
	}
	
	private User getUserById(int id){
		for(Iterator<User> iter = userList.iterator();iter.hasNext();){
			User u = iter.next();
			if(u.getId()==id){
				return u;
			}
		}
		return null;
	}
	
	public void querySingleUser(){
		System.out.println("请输入要查看的用户id");
		int id = sc.nextInt();
		
		User u = getUserById(id);
		if(u==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println(u);
	}
	
	public void userList(){
		if(userList.size()==0){
			System.out.println("没有任何信息");
			return;
		}
		
		for(Iterator<User> iter = userList.iterator();iter.hasNext();){
			User u = iter.next();
			System.out.println(u);
		}
	}
}
