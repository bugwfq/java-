package collection.day170517.test10;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack();
		while(true){
			System.out.println("1.入栈2.出栈3.查看栈内所有用户4.查看栈长度0.退出");
			int mark = sc.nextInt();
			if(mark==1){
				ms.addUser();
			}else if(mark==2){
				ms.deleteUser();
			}else if(mark==3){
				ms.userList();
			}else if(mark==4){
				ms.length();
			}else if(mark==0){
				System.exit(0);
			}
		}
	}
}
