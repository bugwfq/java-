package day170406单向链表.work;

import java.util.Scanner;

import org.junit.Test;

public class UserTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		int mark = 0;
		UserManager chain = new UserManager();
		while(true){
			System.out.println("1.增加用户2.删除用户3.修改用户信息4.查看单个用户信息5.查看所有用户信息0.退出");
			mark = sc.nextInt();
			if(mark==1){
				chain.addUser();
			}else if(mark==2){
				chain.deleteUser();
			}else if(mark==3){
				chain.updateUser();
			}else if(mark==4){
				chain.iterNode();
			}else if(mark==5){
				chain.iterAllNode();
			}else{
				System.exit(0);
			}
		}	
	}
}
