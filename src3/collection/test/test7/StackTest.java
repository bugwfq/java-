package collection.test.test7;

import java.util.Scanner;

import org.junit.Test;

public class StackTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.入栈2.出栈3.查看栈长度4.查看所有用户0.退出");
			int mark = sc.nextInt();
			
			if(mark==1){
				um.addUser();
			}else if(mark==2){
				um.deleteUser();
			}else if(mark==3){
				um.length();
			}else if(mark==4){
				um.userList();
			}else{
				System.exit(0);
			}
		}
	}
}
