package collection.day170517.test10;

import java.util.Scanner;

public class MyStack {
	private User[] user = new User[5];
	private int index = user.length-1;//����±�
	private int length = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ��ջ
	 */
	public void addUser(){
		System.out.println("������Ҫ��ջ���û�id");
		int id = sc.nextInt();
		
		System.out.println("������Ҫ��ջ���û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ջ���û�����");
		String password = sc.next();
		
		//����
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
		System.out.println("��ջ�ɹ�");
	}
	/**
	 * ��ջ
	 */
	public void deleteUser(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
			return;
		}
		
		System.out.println("��ջ���û�Ϊ��"+user[index+1]);
		
		//���������������洢��ջ���Ԫ��
		User[] newU = new User[user.length];
		int tempIndex = user.length-1;
		for(int i=user.length-1;i>index+1;i--){
			newU[tempIndex--] = user[i];
		}
		newU = user;
		index = tempIndex;
		length--;
		System.out.println("��ջ�ɹ�");
	}
	/**
	 * �鿴ջ�������û�
	 */
	public void userList(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
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
	 * �鿴ջ����
	 */
	public void length(){
		System.out.println("��ǰջ����Ϊ��"+length);
	}
}
