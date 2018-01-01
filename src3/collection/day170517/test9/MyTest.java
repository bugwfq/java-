package collection.day170517.test9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.添加用户2.删除用户3.修改用户4.查看单个用户5.查看所有用户信息0.退出");
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
	
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<>();
		list.add(null);
		list.add(3);
		list.add(2);
		list.add(4);
		
		System.out.println("list:"+list);
		
		Set<Integer> set = new HashSet<>();
		set.add(null);
		set.add(3);
		set.add(2);
		set.add(4);
		System.out.println("set:"+set);
	}
	
	@Test
	public void test3(){
		
	}
}
