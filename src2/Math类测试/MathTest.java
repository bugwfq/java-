package Math类测试;

import java.util.Scanner;

import org.junit.Test;
/**
 * 用String 数组arr存本班人数；
 * 用int 数组indexArry存抽取的下标
 * @author Administrator
 *
 */
public class MathTest {
	//@Test
	public void mathTest1(){
		//Math类小练习
		System.out.println(Math.max(0.01,0.02));//查看最大数
		System.out.println(Math.min(10, 20));//查看最小数
		System.out.println(Math.ceil(0.13));//返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
		System.out.println(Math.floor(0.13));// 返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[] arr = {"霍建鹏","薛唱丽","刘超","王福强","火元萍",
				"葛彪祖","霍发成","柴宗元","马廷偲","周玉霞",
				"常立祥","孙英","刘欢","阳辉亮","张旭",
				"钱乐","王中庆","张澳利", "熊德芳","邓亚楠",
				"欧祖祺","唐小帅","肖慧婷","石神光","郭立春",
				"方鹏礼","李建龙","宗志荣","施耀波","张云鹏",
				"李金辉","王启明","王俊杰","梁国文","齐国仓",
				"路强林","伍杰"};
		while(true){//循环操作
			System.out.println("请输入您要抽查的人数：");
			int length=input.nextInt();//接受要抽取的人数
			int[] indexArr = new int[length];//接受抽取人数的下标
			int index=0;
			while(index!=length){//控制循环到想要抽取的人满之后
				boolean bool=false;
				int temp=(int)(1+Math.random()*37);//出一个随机数在1~37的范围内
				for(int j=0;j<indexArr.length;j++){//遍历抽取的数组
					if(temp==indexArr[j]){//如果有重复的则改变标志变量在第二次循环后重新判断是否重复
						bool=true;
						break;
					}
				}
				if(bool==false){//如果没有重复的则存入
					indexArr[index]=temp;
					index++;
				}
			}
			System.out.print("您要抽取的人有：");
			for(int a:indexArr){//遍历数组查看抽取的人
				System.out.print(arr[a-1]+";");//防止下标越界（a-1）
			}
			System.out.println();
			System.out.println("是否继续（y/n）");
			String exic=input.next();
			if(exic.equals("n")){
				System.out.println("谢谢使用！");
				break;
			}
		}
	}
}
