package ���к�ջ;

import java.util.Scanner;

/**
 * ����  (�����ȳ�)
 * @author Administrator
 *
 */
public class MyQueue {
	private Scanner input = new Scanner(System.in);
	private User[] user = new User[10];
	private int index;
	public int length;
	/**
	 * ���
	 */
	public void addUser(){
		if(index==user.length){
			expand();
		}
		System.out.println("��������Ҫ��ӵ��û���");
		String name = input.next();
		System.out.println("��������Ҫ��ӵ��û����䣺");
		int age = input.nextInt();
		user[index]=new User(name,age);
		index ++ ;
		length ++;
	}
	/**
	 * ����
	 */
	public void deleteUser(){
		if(length == 0){
			System.out.println("�ö�����û�г�Ա");
			return;
		}
		System.out.println(user[0]+"���ӳɹ�");
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
	 * �鿴�������г�Ա
	 */
	public void queryUser(){
		if(length == 0){
			System.out.println("�ö�����û�г�Ա");
			return;
		}
		System.out.println("������Ҫ�鿴���û���");
		String name = input.next();
		for(int i = 0; i<index;i++){
			if(name.equals(user[i].getName())){
				System.out.println("���û�����Ϊ"+user[i].getName());
				System.out.println("���û�����Ϊ"+user[i].getAge());
				return;
			}
		}
		System.out.println("û�иó�Ա");
	}
	/**
	 * �鿴����
	 */
	public void queryUserAll(){
		if(length == 0){
			System.out.println("�ö�����û�г�Ա");
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
	 * ���г���
	 * @return
	 */
	public int length(){
		return length;
	}
	/**
	 * ��������
	 */
	public void expand(){
		User[] temp = new User[user.length*2];
		for(int i = 0; i<user.length;i++){
			temp[i]=user[i];
		}
		user=temp;
	}
}
