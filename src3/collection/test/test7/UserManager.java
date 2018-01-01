package collection.test.test7;

import java.util.Scanner;

public class UserManager {
	private Scanner sc = new Scanner(System.in);
	private User[] user = new User[5];
	private int index = user.length-1;
	private int length = 0;
	
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
		user[index].setUsername(name);
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
			System.out.println("ջ��Ϊ��");
			return;
		}
		
		System.out.println("��ջ���û��ǣ�"+user[index+1]);
		
		//�������������洢��ջ���Ԫ��
		User[] newU = new User[user.length];
		int tempIndex = user.length-1;
		for(int i=user.length-1;i>index+1;i--){
			newU[tempIndex--] = user[i];
		}
		user = newU;
		index = tempIndex;
		length--;
		System.out.println("��ջ�ɹ�");
		
	}
	
	/**
	 * �鿴ջ������Ԫ��
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
		System.out.println(builder.substring(0, builder.length()-2));
	}
	
	
	/**
	 * �鿴ջ����
	 */
	public void length(){
		System.out.println("ջ����Ϊ��"+length);
	}
	
	
}
