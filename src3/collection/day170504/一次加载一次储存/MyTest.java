package collection.day170504.һ�μ���һ�δ���;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		
		while(true){
			
			System.out.println("1.����û�2.ɾ���û�3.�޸��û�4.�鿴�����û�5.�鿴�����û�0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				um.addUser();
			}else if(mark==2){
				um.deleteUser();
			}else if(mark==3){
				um.updateUser();
			}else if(mark==4){
				um.querySingleUser();
			}else if(mark==5){
				um.userList();
			}else{
				UserManager.storeData();
				System.exit(0);
				
			}
		}
	}
}
