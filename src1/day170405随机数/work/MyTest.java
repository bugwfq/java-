package day170405随机数.work;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		String[] str = {"刘超","马廷偲","周玉霞","常立祥","葛彪祖","薛唱丽","孙英","王福强","刘欢","阳辉亮","张旭","钱乐","王中庆","张澳利","熊德芳","邓亚楠","欧祖祺","唐小帅","肖慧婷","石神光","火元萍","郭立春","方鹏礼","李建龙","宗志荣","施耀波","张云鹏","李金辉","王启明","王俊杰","梁国文","齐国仓","路强林","霍发成","伍杰","霍建鹏","柴宗元"};	
		while(true){
			System.out.println("请输入要抽取的学生个数：");
			int num = sc.nextInt();
			int[] temp = new int[num];//用来存放抽取出的学生下标
			int index = 0;
			while(index!=num){
				boolean bool = false;
				int count = (int)(1+Math.random()*37)-1;//记录随机产生的下标数
				for(int i=0;i<num;i++){
					if(count==temp[i]){//如果重复
						bool=true;
						break;
					}
				}
				if(bool==false){//不重复
					temp[index++]=count;
				}
			}
			for(int i=0;i<temp.length;i++){
				System.out.println(str[temp[i]]);
			}			
		}		
	}
	@Test
	public void test2(){
		System.out.println(Math.max(1.23, 0.52));//返回两个 double 值中较大的一个
		System.out.println(Math.max(0.1f, 0.3f));//返回两个 float 值中较大的一个
		System.out.println(Math.max(3, 5));//返回两个 int 值中较大的一个
		System.out.println(Math.max(100L, 1222L));//返回两个 long 值中较大的一个
		
		System.out.println(Math.min(1.23, 0.52));//返回两个 double 值中较小的一个
		System.out.println(Math.min(0.1f, 0.3f));//返回两个 float 值中较小的一个
		System.out.println(Math.min(3, 5));//返回两个 int 值中较小的一个
		System.out.println(Math.min(100L, 1222L));//返回两个 long 值中较小的一个
		System.out.println("----------------");
		System.out.println(Math.ceil(1.22));//2.0 ->返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数
		System.out.println(Math.floor(1.99));//1.0 ->返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数
		System.out.println(Math.round(1.56));//2  -> 返回最接近参数的 int
		System.out.println(Math.random());//返回带正号的 double 值，该值大于等于 0.0 且小于 1.0
	}
}
