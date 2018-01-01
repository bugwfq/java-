package collection.day170502.work;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class SetRandomTest {
	//@Test
	public void test1(){	
		Scanner sc = new Scanner(System.in);
		String[] str = {"刘超","马廷偲","周玉霞","常立祥",
				"葛彪祖","薛唱丽","孙英","王福强","刘欢",
				"阳辉亮","张旭","钱乐","王中庆","张澳利",
				"熊德芳","邓亚楠","欧祖祺","唐小帅","肖慧婷",
				"石神光","火元萍","郭立春","方鹏礼","李建龙",
				"宗志荣","施耀波","张云鹏","王启明","王俊杰",
				"梁国文","齐国仓","路强林","霍发成","伍杰","霍建鹏","柴宗元"};
		while(true){
			System.out.println("请输入要随机出的学生数");
			int num = sc.nextInt();
			
			//声明一个Set集合用来存储随机到的学生
			Set<String> set = new HashSet<>();
			while(true){
				if(num==set.size()){//当随机的学生数与set集合的长度相同时，结束循环体
					break;
				}
				Random r = new Random();
				//将随机数作为数组下标，并将学生添加到set集合中
				set.add(str[r.nextInt(36)]);//下标是0-35				
			}
			System.out.println(set);
		}
	}	
	@Test
	public void test2(){
		Random r = new Random();
		//获取订单号
		String orderNum = "INDENT20170000"+r.nextInt(1000000);
		System.out.println(orderNum);
	}
	
}

