package collection.day170517.test8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class test3 {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String str = sc.nextLine();
		
		//将字符串转化成数组
		char[] cc = str.toCharArray();
		
		//声明一个集合
		Map<Character, Integer> map = new HashMap<>();
		//遍历数组，将数组的元素作为集合的键
		for(int i=0;i<cc.length;i++){
			//通过键获取值
			Integer value = map.get(cc[i]);
			if(value==null){
				map.put(cc[i], 1);
			}else {
				map.put(cc[i], value+1);
			}			
		}
		
		//遍历集合
		Set<Character> keys = map.keySet();
		for(Iterator<Character> iter = keys.iterator();iter.hasNext();){
			Character key = iter.next();
			Integer value = map.get(key);
			
			System.out.println(key+":"+value);
		}
		
	}
	
	
	@Test
	public void test2(){
		
	}
}
