package day170404����VS��ջ.work;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class MyQueue {
	private  User[] user = new User[10];
	private int index = 0;
	private int length = 0;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * ���
	 */
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�����");
		String name = sc.next();
		System.out.println("������Ҫ��ӵ��û����䣺");
		int age = sc.nextInt();
		System.out.println("������Ҫ��ӵ��û��Ա�");
		String sex = sc.next();
		//ʵ�ֶ�̬����
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
		System.out.println("��ӳɹ���");
	}
	/**
	 * ����
	 */
	public void deleteUser(){
		if(length==0){
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		System.out.println("Ҫ���ӵ�Ԫ��Ϊ��"+user[0]);
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
	 * �鿴���г���
	 */
	public void length(){
		System.out.println("��ǰ���г���Ϊ��"+length);
	}
	/**
	 * �鿴��������Ԫ��
	 */
	public void querySingleUser(){
		if(length==0){
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		System.out.println("������Ҫ�鿴���û�����");
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
			System.out.println("���û���Ϊ��"+user[temp].getUserName());
			System.out.println("���û�������Ϊ��"+user[temp].getUserAge());
			System.out.println("���û����Ա�Ϊ��"+user[temp].getUserSex());	
		}else{
			System.out.println("û�и��û�");
		}
		
	}
	/**
	 * �鿴���ж���Ԫ��
	 */
	public void userList(){
		if(length==0){
			System.out.println("��ǰ����Ϊ��");
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
