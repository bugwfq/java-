package ���к�ջ;

import java.util.Scanner;

/**
 * ��ջ
 * @author Administrator
 *
 */
public class MyStack {
	private Scanner input = new Scanner(System.in);
	private User[] user = new User[10];
	private int index=user.length-1;
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
		index--;
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
		System.out.println(user[index+1]+"���ӳɹ�");
		User[] temp = new User[user.length];
		for(int i =user.length-1;i>index+1;i--){
			temp[i]=user[i];
		}
		user = temp;
		index ++ ;
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
		for(int i = index+1; i<user.length;i++){
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
		for(int i = index+1; i<user.length;i++){
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
		int tempIndex=temp.length-1;
		for(int i = user.length-1; i>index;i--){
			temp[tempIndex]=user[i];
			tempIndex--;
		}
		index=tempIndex;
		user=temp;
	}
}
