package collection.day170517.test6;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager m = new UserManager();
		while(true){
			System.out.println("1.��ջ2.��ջ3.�鿴ջ������4.�鿴ջ����0.�˳�");
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
