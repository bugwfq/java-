package collection.test.test10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class RandomTest2 {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		String[] str = {"aa","bb","cc","dd","ee","ff"};
		
		Random r = new Random();
		while(true){	
			System.out.println("请输入要查看的个数");
			int num = sc.nextInt();
			
			//声明一个list集合，用来存储随机出的元素
			List<String> list = new ArrayList<>();
			while(list.size()!=num){
				
				int temp = r.nextInt(6);//随机出的数用来做数组元素下标
				if(list.contains(str[temp])){
					continue;
				}
				list.add(str[temp]);
			}
			System.out.println(list);		
		}
		
	}
}
