package collection.day170517.test5;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.����û�2.ɾ���û�3.�޸��û�4.�鿴�����û�5.�鿴�����û�0.�˳�");
			int mark = sc.nextInt();
			
			if(mark==1){
				um.add();
			}else if(mark==2){
				um.delete();
			}else if(mark==3){
				um.update();
			}else if(mark==4){
				um.querySingle();
			}else if(mark==5){
				um.list();
			}else{
				System.exit(0);
			}
		}
	}
}
