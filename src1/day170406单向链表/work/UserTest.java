package day170406��������.work;

import java.util.Scanner;

import org.junit.Test;

public class UserTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		int mark = 0;
		UserManager chain = new UserManager();
		while(true){
			System.out.println("1.�����û�2.ɾ���û�3.�޸��û���Ϣ4.�鿴�����û���Ϣ5.�鿴�����û���Ϣ0.�˳�");
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
