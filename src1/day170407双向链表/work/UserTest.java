package day170407双向链表.work;

import java.util.Scanner;

import org.junit.Test;

public class UserTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		UserManager userManager = new UserManager();
		while(true){
			System.out.println("1.增加用户2.删除用户3.修改用户4.从左往右5.从右往左6.查询单个用户0.退出");
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
			System.out.println("1.增加(前)2.添加(后)3.查看0.退出");
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
