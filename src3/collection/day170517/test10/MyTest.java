package collection.day170517.test10;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack();
		while(true){
			System.out.println("1.��ջ2.��ջ3.�鿴ջ�������û�4.�鿴ջ����0.�˳�");
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
