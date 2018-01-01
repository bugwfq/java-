package exception.day170525;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class RandomTest{
	//@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		String[] str={"刘超","马廷偲","周玉霞","常立祥","葛彪祖","薛唱丽","孙英","王福强","刘欢","杨辉亮","张旭","钱乐","王中庆"
				,"张奥利","熊得芳","邓亚楠","欧祖祺","唐小帅","肖慧婷","石神光","火元萍","郭立春","方鹏礼","李建龙","宗志荣"
				,"施耀波","张云鹏","李金辉","王启明","王俊杰","梁国文","齐国仓","路强林","霍发成","伍杰","霍建鹏","柴宗元"};
		while(true){
			System.out.println("请输入要随机出的学生数");
			int count = sc.nextInt();
			
			List<String> list = new ArrayList<>();
			Random r = new Random();
			while(list.size()<count){
				int temp = r.nextInt(36);
				if(!list.contains(str[temp])){
					list.add(str[temp]);
				}
			}
			
			System.out.println(list);
		}
	
	}	
	
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			list.remove(i);
			System.out.println(list.size());
		}
	}
	
	@Test
	public void test3(){
		
	}
}
