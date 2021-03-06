package 队列和栈;

import java.util.Scanner;

/**
 * 队列  (先入先出)
 * @author Administrator
 *
 */
public class MyQueue {
	private Scanner input = new Scanner(System.in);
	private User[] user = new User[10];
	private int index;
	public int length;
	/**
	 * 入队
	 */
	public void addUser(){
		if(index==user.length){
			expand();
		}
		System.out.println("请输入您要入队的用户名");
		String name = input.next();
		System.out.println("请输入您要入队的用户年龄：");
		int age = input.nextInt();
		user[index]=new User(name,age);
		index ++ ;
		length ++;
	}
	/**
	 * 出队
	 */
	public void deleteUser(){
		if(length == 0){
			System.out.println("该队列中没有成员");
			return;
		}
		System.out.println(user[0]+"出队成功");
		User[] temp = new User[index-1];
		int tempIndex=0;
		for(int i = 1;i<index;i++){
			temp[tempIndex]=user[i];
			tempIndex ++;
		}
		user = temp;
		index = tempIndex;
		length --;
	}
	/**
	 * 查看单个队列成员
	 */
	public void queryUser(){
		if(length == 0){
			System.out.println("该队列中没有成员");
			return;
		}
		System.out.println("请输入要查看的用户名");
		String name = input.next();
		for(int i = 0; i<index;i++){
			if(name.equals(user[i].getName())){
				System.out.println("该用户姓名为"+user[i].getName());
				System.out.println("该用户年龄为"+user[i].getAge());
				return;
			}
		}
		System.out.println("没有该成员");
	}
	/**
	 * 查看所有
	 */
	public void queryUserAll(){
		if(length == 0){
			System.out.println("该队列中没有成员");
			return;
		}
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<index;i++){
			str.append(user[i]+"->");
		}
		str.trimToSize();
		System.out.println(str.subSequence(0, str.length()-2));
	}
	/**
	 * 队列长度
	 * @return
	 */
	public int length(){
		return length;
	}
	/**
	 * 数组扩容
	 */
	public void expand(){
		User[] temp = new User[user.length*2];
		for(int i = 0; i<user.length;i++){
			temp[i]=user[i];
		}
		user=temp;
	}
}
