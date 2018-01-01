package day170324;

import java.util.Scanner;

public class Test {
	

	/**
	 * ��¼�˺Ŵ����¼
	 */
	public static ErrorLoginInfo[] elis = new ErrorLoginInfo[10];
	public static int index = 0;
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.��¼2.ע��3.�˳�");
			int mark = sc.nextInt();
			if(mark == ConstantInterface.LOGIN){
				login();//��¼
			}else if(mark == ConstantInterface.REGISTER){
				um.addUser();//ע��
			}else{
				System.out.println("ϵͳ�˳�");
				break;
			}
		}
	}		
	
	/**
	 * ����Ա�˵�
	 */
	private static void adminMenu(){
		
		while(true){
			System.out.println("1.�༶����2.ѧ������3.�������4.�û�����5.������һ��");
			int mark = sc.nextInt();
		}
	}
	
	/**
	 * �����β˵�
	 */
	private static void teacherLeaderMenu(){
		while(true){
			System.out.println("1.�༶����2.ѧ������3.�������4.�û�����5.������һ��");
			int mark = sc.nextInt();
		}
	}
	
	/**
	 * �ο���ʦ�˵�
	 */
	private static void teacherMenu(){
		while(true){
			System.out.println("1.�༶����2.ѧ������3.�������4.�û�����5.������һ��");
			int mark = sc.nextInt();
		}
	}
	
	
	
	private static void login(){//��¼����
		System.out.println("�������û���");
		String username = sc.next();
		
		User user = Tools.getUserByUsername(username);
		if(user == null){
			System.out.println("�Ƿ����˺�.");
			return ;
		}
		
		ErrorLoginInfo eli1 = Tools.getErrorLoginInfoByUsername(username);
		if(eli1 != null && eli1.getCount() >= ConstantInterface.ERROR_COUNT){
			System.out.println("������¼ϵͳ�Ĵ�������������Σ������������¼.");
			return ;
		}
		
		System.out.println("����������");
		String password = sc.next();
		
		user = Tools.getUserByUnAndPwd(username, password);
		if(user != null){
			System.out.println("��¼�ɹ�.");
			if(user.getLevel() == ConstantInterface.ADMIN_MENU){
				adminMenu();
			}else if(user.getLevel() == ConstantInterface.TEACHER_LEADER_MENU){
				teacherLeaderMenu();
			}else if(user.getLevel() == ConstantInterface.TEACHER_MENU){
				teacherMenu();
			}
			// �������¼���еļ�¼����
			ErrorLoginInfo eli = Tools.getErrorLoginInfoByUsername(username);
			if(eli != null){//����д����¼��¼���ֵ�¼�ɹ��ˣ��ͽ������¼��¼����
				eli.setCount(0);
			}
		}else{
			// ��¼ʧ��
			// 1.��ǰ�˺��ڴ����¼��¼����û�м�¼(����һ����¼)
			ErrorLoginInfo eli = Tools.getErrorLoginInfoByUsername(username);
			if(eli == null){
				ErrorLoginInfo newEli = new ErrorLoginInfo(username,1);
				elis[index] = newEli;
				index ++;
			}
			// 2.��ǰ�˺��ڴ����¼��¼�����м�¼(���������+1)
			else{
				eli.setCount(eli.getCount()+1);
			}
			
			System.out.println("��¼ʧ�ܣ������µ�¼.");
		}
		
	}
}
