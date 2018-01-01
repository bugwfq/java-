package collection.day170517.test5;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.添加用户2.删除用户3.修改用户4.查看单个用户5.查看所有用户0.退出");
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
