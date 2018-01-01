package collection.day170517.test6;

import java.util.Scanner;

public class UserManager {
	private User[] user = new User[10];
	private int index = user.length-1;
	private int length;
	
	private Scanner sc = new Scanner(System.in);                 
	
	/**
	 * ��ջ
	 */
	public void add(){
		//����
		if(index==user.length){
			User[] newUser = new User[user.length*2];
			int tempIndex = user.length-1;
			for(int i=user.length-1;i>0;i--){
				newUser[tempIndex--] = user[i]; 
			}
			user = newUser;
			index = tempIndex;
		}
		
		System.out.println("������Ҫ��ջ���û�id");
		int id = sc.nextInt();
		
		System.out.println("������Ҫ��ջ���û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ջ���û�����");
		String password = sc.next();
		
		User u = new User(id,name,password);
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
	public void delete(){
		if(length==0){
			System.out.println("��ǰջ��û���κ��û�");
			return;
		}
		
		System.out.println("��ջ��Ԫ��Ϊ��"+user[index+1]);
		
		//�½�һ�����������洢��ջ���Ԫ��
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
	 * �鿴����ջ��Ԫ��
	 */
	public void userList(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=user.length-1;i>0;i--){
			if(user[i]!=null){
				builder.append(user[i]+"->");
			}	
		}
		
		builder.trimToSize();
		System.out.println(builder.substring(0, builder.length()-2));
	}
	/**
	 * �鿴ջ����
	 */
	public void length(){
		System.out.println(length);
	}
}
