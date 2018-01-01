package collection.day170502.work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class ListRandomTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		
		String[] str = {"刘超","马廷偲","周玉霞","常立祥","葛彪祖","薛唱丽","孙英","王福强","刘欢","阳辉亮","张旭","钱乐","王中庆","张澳利","熊德芳","邓亚楠","欧祖祺","唐小帅","肖慧婷","石神光","火元萍","郭立春","方鹏礼","李建龙","宗志荣","施耀波","张云鹏","王启明","王俊杰","梁国文","齐国仓","路强林","霍发成","伍杰","霍建鹏","柴宗元"
};	
		while(true){
			System.out.println("请输入要查看的学生数");
			int num = sc.nextInt();
			
			//声明一个List集合来存储随机到的学生
			List<String> list = new ArrayList<>();
			Random r = new Random();
			while(true){
				if(num==list.size()){
					break;
				}
				int temp = r.nextInt(36);
				if(list.contains(str[temp])){
					continue;
				}
				list.add(str[temp]);
			}
			System.out.println(list);
		}
		
	}
}
