package collection.test.test9;

import java.util.Scanner;

import org.junit.Test;


public class DoubleChainTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.添加用户2.删除用户3.修改用户4.查看单个用户5.查看所有用户0.退出");
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
				System.exit(0);
			}			
		}
	}	
}
