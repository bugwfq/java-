package day170407˫������.work;

import java.util.Scanner;

import org.junit.Test;

public class UserTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		UserManager userManager = new UserManager();
		while(true){
			System.out.println("1.�����û�2.ɾ���û�3.�޸��û�4.��������5.��������6.��ѯ�����û�0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				userManager.addUser();
			}else if(mark==2){
				userManager.deleteUser();
			}else if(mark==3){
				userManager.updataUser();
			}else if(mark==4){
				userManager.ltr();
			}else if(mark==5){
				userManager.rtl();
			}else if(mark==6){
				userManager.iterSingleUser();
			}else{
				System.exit(0);
			}
		}
	}
	@Test 
	public void test2(){
		Scanner sc = new Scanner(System.in);
		UserManager userManager = new UserManager();
		while(true){
			System.out.println("1.����(ǰ)2.���(��)3.�鿴0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				userManager.addBefore();
			}else if(mark==2){
				userManager.addAfter();
			}else if(mark==3){
				userManager.ltr();
			}else{
				System.exit(0);
			}
		}
	}
}
