package day170324;

import java.util.Scanner;

public class UserManager {

	
	public static User[] users = new User[10];
	public static int index = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * �����û�
	 */
	public void addUser(){//�û�ע��
	
		System.out.println("�������û�id");
		int id = sc.nextInt();
		
		User user = Tools.getUserById(id);
		if(user != null){
			System.out.println("���û�id�Ѵ���.");
			return ;
		}
		
		System.out.println("�������û���");
		String username = sc.next();
		user = Tools.getUserByUsername(username);
		if(user != null){
			System.out.println("���û�����ע��.");
			return ;
		}
		
		System.out.println("�������û�����");
		String password = sc.next();
		
		System.out.println("��ѡ���û��ȼ�:1.����Ա2.������3.�ο���ʦ");
		int level = sc.nextInt();
		
		User newUser = new User(id, username, password, level);
		users[index] = newUser;
		index ++;
		System.out.println("�û�ע��ɹ�.");
	}
	
	/**
	 * �û��б�
	 */
	public void userList(){
		System.out.println("�����û���Ϣ����:");
		for(int i = 0;i<index;i++){
			System.out.println(users[i]);
		}
	}
}
