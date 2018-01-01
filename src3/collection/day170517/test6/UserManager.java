package collection.day170517.test6;

import java.util.Scanner;

public class UserManager {
	private User[] user = new User[10];
	private int index = user.length-1;
	private int length;
	
	private Scanner sc = new Scanner(System.in);                 
	
	/**
	 * 入栈
	 */
	public void add(){
		//扩容
		if(index==user.length){
			User[] newUser = new User[user.length*2];
			int tempIndex = user.length-1;
			for(int i=user.length-1;i>0;i--){
				newUser[tempIndex--] = user[i]; 
			}
			user = newUser;
			index = tempIndex;
		}
		
		System.out.println("请输入要入栈的用户id");
		int id = sc.nextInt();
		
		System.out.println("请输入要入栈的用户名");
		String name = sc.next();
		
		System.out.println("请输入要入栈的用户密码");
		String password = sc.next();
		
		User u = new User(id,name,password);
		user[index] = new User();
		user[index].setId(id);
		user[index].setName(name);
		user[index].setPassword(password);
		
		index--;
		length++;
		System.out.println("入栈成功");
		
	}
	
	/**
	 * 出栈
	 */
	public void delete(){
		if(length==0){
			System.out.println("当前栈内没有任何用户");
			return;
		}
		
		System.out.println("出栈的元素为："+user[index+1]);
		
		//新建一个数组用来存储出栈后的元素
		User[] newU = new User[user.length];
		int tempIndex = user.length-1;
		for(int i=user.length-1;i>index+1;i--){
			newU[tempIndex--] = user[i];
		}
		
		user = newU;
		index = tempIndex;
		length--;
		System.out.println("出栈成功");
	}
	/**
	 * 查看所有栈内元素
	 */
	public void userList(){
		if(length==0){
			System.out.println("当前栈内为空");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=user.length-1;i>0;i--){
			if(user[i]!=null){
				builder.append(user[i]+"->");
			}	
		}
		
		builder.trimToSize();
		System.out.println(builder.substring(0, builder.length()-2));
	}
	/**
	 * 查看栈长度
	 */
	public void length(){
		System.out.println(length);
	}
}
