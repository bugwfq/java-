package collection.test.test10;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class RandomTest {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		String[] str = {"aa","bb","cc","dd","ee"};
		
		Random r = new Random();
		while(true){
			System.out.println("请输入要查看的学生数");
			int num = sc.nextInt();
			
			Set<String> set = new HashSet<>();	
			while(set.size()!=num){
				int temp = r.nextInt(5);			
				set.add(str[temp]);
			}
			
			System.out.println(set);
		}
		
 	}
}
