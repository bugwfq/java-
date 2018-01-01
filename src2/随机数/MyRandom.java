package 随机数;

import java.util.Scanner;

import org.junit.Test;

public class MyRandom {
	@Test
	public void test1(){
		//"刘超","马廷偲","周玉霞","常立祥","葛彪祖","薛唱丽","孙英","王福强","刘欢","阳辉亮","张旭","钱乐","王中庆","张澳利","熊德芳","邓亚楠","欧祖祺","唐小帅","肖慧婷","石神光","火元萍","郭立春","方鹏礼","李建龙","宗志荣","施耀波","张云鹏","李金辉","王启明","王俊杰","梁国文","齐国仓","路强林","霍发成","伍杰","霍建鹏","柴宗元"
		Scanner sc = new Scanner(System.in);
		String[] s = {"刘超","马廷偲","周玉霞","常立祥","葛彪祖","薛唱丽","孙英","王福强","刘欢","阳辉亮","张旭","钱乐","王中庆","张澳利","熊德芳","邓亚楠","欧祖祺","唐小帅","肖慧婷","石神光","火元萍","郭立春","方鹏礼","李建龙","宗志荣","施耀波","张云鹏","李金辉","王启明","王俊杰","梁国文","齐国仓","路强林","霍发成","伍杰","霍建鹏","柴宗元"};
		while(true){
			System.out.println("请输入要抽取的人数个数：");
			int count = sc.nextInt();
			int[] temp = new int[count];//存下标
			int index = 0;
			while(index!=count){
				boolean bool = false;
				int num = (int)(1+Math.random()*37)-1;
				for(int i=0;i<count;i++){
					if(temp[i]==num){
						bool = true;
						break;
					}
				}
				if(bool==false){
					temp[index++] = num;
				}	
			}
			for(int i=0;i<temp.length;i++){
				System.out.println(s[temp[i]]);
			}	
		}	
	}
	
}
