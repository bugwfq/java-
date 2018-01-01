package collection.day170517.test6;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager m = new UserManager();
		while(true){
			System.out.println("1.入栈2.出栈3.查看栈内所有4.查看栈长度0.退出");
			int mark = sc.nextInt();
			
			if(mark==1){
				m.add();
			}else if(mark==2){
				m.delete();
			}else if(mark==3){
				m.userList();
			}else if(mark==4){
				m.length();
			}else{
				System.exit(0);
			}
		}
	}
}
