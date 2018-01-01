package day170404队列VS堆栈.work;

import java.util.Scanner;

import day170404队列VS堆栈.work.User;

public class MyStack {
	private User[] user = new User[10];
	private int index = user.length-1;//指向最大下标
	private int length;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 入栈
	 */
	public void addUser(){
		System.out.println("请输入要入栈的用户名：");
		String name = sc.next();
		System.out.println("请输入要入栈的用户年龄：");
		int age = sc.nextInt();
		System.out.println("请输入要入栈的用户性别：");
		String sex = sc.next();
		//实现动态扩容
		if(index==user.length){
			User[] newUser = new User[user.length*2];
			int tempIndex = newUser.length-1;
			for(int i=user.length-1;i>0;i--){
				newUser[tempIndex] = user[i];
				tempIndex--;
			}
			user = newUser;
			index = tempIndex;
		}
		user[index] = new User();
		user[index].setUserName(name);
		user[index].setUserAge(age);
		user[index].setUserSex(sex);
		index--;
		length++;
		System.out.println("入栈成功！");
	}
	/**
	 * 出栈
	 */
	public void deleteUser(){
		if(length==0){
			System.out.println("当前栈内为空");
		}
		System.out.println("要出栈的元素为："+user[index+1]);
		User[] newUser = new User[user.length];
		int tempIndex = user.length-1;
		for(int i=user.length-1;i>index+1;i--){
			newUser[tempIndex] = user[i];
			tempIndex--;
		}
		user = newUser;
		index=tempIndex;
		length--;	
	}
	/**
	 * 查看栈长度
	 */
	public void length(){
		System.out.println("当前栈的长度是："+length);
	}
	/**
	 * 查看栈内所有元素
	 */
	public void userList(){
		if(length==0){
			System.out.println("当前栈内为空");
		}
		StringBuilder builder = new StringBuilder();
		for(int i=index+1;i<user.length;i++){
			builder.append(user[i]+"->");
		}
		builder.trimToSize();
		System.out.println(builder.substring(0,builder.length()-2));
	}
}
