package collection.day170517.test1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class ArrayListTest {
	//@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		while(true){
			System.out.println("1.添加2.删除3.修改4.查看单个5.查看所有0.退出");
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

	@Test
	public void test1(){
		int[] arr = {1,2,3,6};
		int[] arr1 = {1,9,8,5,0,2,3,6};
//		int[] arr2 = {1,2,3,6};
//		List<int[]> list = Arrays.asList(arr,arr1,arr2);
//		for (Iterator<int[]> iter = list.iterator();iter.hasNext();) {
//			int[] key = iter.next();
//			for (int i : key) {
//				System.out.println(i);
//			}
//		}
		
		
		Arrays.sort(arr1);
		for (int i : arr1) {
			System.out.println(i);
		}
	}
}
