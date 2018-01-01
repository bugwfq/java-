package day170404队列VS堆栈.work;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class MyQueue {
	private  User[] user = new User[10];
	private int index = 0;
	private int length = 0;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 入队
	 */
	public void addUser(){
		System.out.println("请输入要入队的用户名：");
		String name = sc.next();
		System.out.println("请输入要入队的用户年龄：");
		int age = sc.nextInt();
		System.out.println("请输入要入队的用户性别：");
		String sex = sc.next();
		//实现动态扩容
		if(index == user.length){
			User[] newUser = new User[user.length*2];
			for(int i=0;i<user.length;i++){
				newUser[i] = user[i];
			}
			user = newUser;
		}
		user[index] = new User();
		user[index].setUserName(name);
		user[index].setUserAge(age);
		user[index].setUserSex(sex);
		index++;
		length++;
		System.out.println("入队成功！");
	}
	/**
	 * 出队
	 */
	public void deleteUser(){
		if(length==0){
			System.out.println("当前队列为空");
			return;
		}
		System.out.println("要出队的元素为："+user[0]);
		User[] newUser = new User[user.length-1];
		int newIndex = 0;
		for(int i=1;i<index;i++){
			newUser[newIndex] = user[i];
			newIndex++;
		}
		user = newUser;
		index = newIndex;
		length--;
	}
	/**
	 * 查看队列长度
	 */
	public void length(){
		System.out.println("当前队列长度为："+length);
	}
	/**
	 * 查看单个队列元素
	 */
	public void querySingleUser(){
		if(length==0){
			System.out.println("当前队列为空");
			return;
		}
		System.out.println("请输入要查看的用户名：");
		String name = sc.next();
		boolean bool = false;
		int temp = 0;
		for(int i=0;i<index;i++){
			if(name.equals(user[i].getUserName())){
				bool = true;
				temp = i;
				break;
			}
		}
		if(bool==true){
			System.out.println("该用户名为："+user[temp].getUserName());
			System.out.println("该用户的年龄为："+user[temp].getUserAge());
			System.out.println("该用户的性别为："+user[temp].getUserSex());	
		}else{
			System.out.println("没有该用户");
		}
		
	}
	/**
	 * 查看所有队列元素
	 */
	public void userList(){
		if(length==0){
			System.out.println("当前队列为空");
			return;
		}
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(user[i]+"->");
		}
		builder.trimToSize();
		System.out.println(builder.substring(0, builder.length()-2));
	}
}
