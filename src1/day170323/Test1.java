package day170323;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminManager am = new AdminManager();
		am.adminLogin();
	}

}
class AdminManager{
	Scanner input = new Scanner(System.in);
	public static Administrator[] admin = new Administrator[10];	
	public static int index = 0;
	public void adminLogin(){//����Ա��¼
		admin[0] = new Administrator();
		admin[0].setAdminName("admin");//������Աһ���̶��ĵ�¼��������
		admin[0].setAdminPassword("admin");
		boolean temp = true;
		int index = 0;
		while(temp){		
			System.out.println("���������Ա�˺ţ�");
			String adminName = input.next();
			System.out.println("���������Ա���룺");
			String adminPassword = input.next();
			if(adminName.equals("admin") && adminPassword.equals("admin")){
				System.out.println("��ӭ����Ա�ɹ���¼��");
				break;
			}else{
				System.out.println("�˺Ż��������������");
				index++;
				if(index==3){
					System.out.println("�������3�Σ��˺��Ѷ��ᣬ����ϵ***");
					break;
				}
			}	
		}
		
	}
}
