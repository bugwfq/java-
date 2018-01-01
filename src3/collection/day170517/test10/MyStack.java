package collection.day170517.test10;

import java.util.Scanner;

public class MyStack {
	private User[] user = new User[5];
	private int index = user.length-1;//最大下标
	private int length = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 入栈
	 */
	public void addUser(){
		System.out.println("请输入要入栈的用户id");
		int id = sc.nextInt();
		
		System.out.println("请输入要入栈的用户名");
		String name = sc.next();
		
		System.out.println("请输入要入栈的用户密码");
		String password = sc.next();
		
		//扩容
		if(index==0){
			User[] newU = new User[user.length*2];
			int tempIndex = newU.length-1;
			for(int i=user.length-1;i>index;i--){
				newU[tempIndex--] = user[i];
			}
			user = newU;
			index = tempIndex;
		}
		
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
	public void deleteUser(){
		if(length==0){
			System.out.println("当前栈内为空");
			return;
		}
		
		System.out.println("出栈的用户为："+user[index+1]);
		
		//创建新数组用来存储出栈后的元素
		User[] newU = new User[user.length];
		int tempIndex = user.length-1;
		for(int i=user.length-1;i>index+1;i--){
			newU[tempIndex--] = user[i];
		}
		newU = user;
		index = tempIndex;
		length--;
		System.out.println("出栈成功");
	}
	/**
	 * 查看栈内所有用户
	 */
	public void userList(){
		if(length==0){
			System.out.println("当前栈内为空");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=user.length-1;i>index;i--){
			builder.append(user[i]+"->");
		}
		
		builder.trimToSize();
		System.out.println(builder.substring(0, builder.length()-2));
	}
	/**
	 * 查看栈长度
	 */
	public void length(){
		System.out.println("当前栈长度为："+length);
	}
}
