package day170404����VS��ջ.work;

import java.util.Scanner;

import day170404����VS��ջ.work.User;

public class MyStack {
	private User[] user = new User[10];
	private int index = user.length-1;//ָ������±�
	private int length;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * ��ջ
	 */
	public void addUser(){
		System.out.println("������Ҫ��ջ���û�����");
		String name = sc.next();
		System.out.println("������Ҫ��ջ���û����䣺");
		int age = sc.nextInt();
		System.out.println("������Ҫ��ջ���û��Ա�");
		String sex = sc.next();
		//ʵ�ֶ�̬����
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
		System.out.println("��ջ�ɹ���");
	}
	/**
	 * ��ջ
	 */
	public void deleteUser(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
		}
		System.out.println("Ҫ��ջ��Ԫ��Ϊ��"+user[index+1]);
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
	 * �鿴ջ����
	 */
	public void length(){
		System.out.println("��ǰջ�ĳ����ǣ�"+length);
	}
	/**
	 * �鿴ջ������Ԫ��
	 */
	public void userList(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
		}
		StringBuilder builder = new StringBuilder();
		for(int i=index+1;i<user.length;i++){
			builder.append(user[i]+"->");
		}
		builder.trimToSize();
		System.out.println(builder.substring(0,builder.length()-2));
	}
}
