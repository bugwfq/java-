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
	public void adminLogin(){//管理员登录
		admin[0] = new Administrator();
		admin[0].setAdminName("admin");//给管理员一个固定的登录名和密码
		admin[0].setAdminPassword("admin");
		boolean temp = true;
		int index = 0;
		while(temp){		
			System.out.println("请输入管理员账号：");
			String adminName = input.next();
			System.out.println("请输入管理员密码：");
			String adminPassword = input.next();
			if(adminName.equals("admin") && adminPassword.equals("admin")){
				System.out.println("欢迎管理员成功登录！");
				break;
			}else{
				System.out.println("账号或密码错误！请重试");
				index++;
				if(index==3){
					System.out.println("输入错误3次！账号已冻结，请联系***");
					break;
				}
			}	
		}
		
	}
}
