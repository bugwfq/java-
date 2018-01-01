package day170404队列VS堆栈.test;

import java.util.Scanner;

import day170324.User;

public class MyStack {
	private String[] s = new String[5];
	private int index = s.length-1;
	private int length = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 入栈
	 */
	public void addElement(){
		System.out.println("请输入要入栈的元素");
		String data = sc.next();
		
		//扩容
		if(index==0){
			String[] newS = new String[s.length*2];
			int tempIndex = newS.length-1;
			for(int i=s.length-1;i>index;i--){
				newS[tempIndex--] = s[i];
			}
			
			s = newS;
			index = tempIndex;
		}
		
		s[index] = data;
		index--;
		length++;
		System.out.println("入栈成功");
		
	}
	/**
	 * 出栈
	 */
	public void deleteElement(){
		if(length==0){
			System.out.println("当前栈内为空");
			return;
		}
		
		System.out.println("出栈的元素是："+s[index+1]);
		
		//创建一个新数组用来存储出栈后的元素
		String[] newS = new String[s.length];
		int tempIndex = s.length-1;
		for(int i=s.length-1;i>index+1;i--){
			newS[tempIndex--] = s[i];
		}
		s = newS;
		index = tempIndex;
		length--;
		System.out.println("出栈成功");
	}
	/**
	 * 查看栈长度
	 */
	public void length(){
		System.out.println("当前栈长度是："+length);
	}
	/**
	 * 查看栈内元素
	 */
	public void allElements(){
		if(length==0){
			System.out.println("当前栈内为空");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=s.length-1;i>index;i--){
			builder.append(s[i]+"->");
		}
		System.out.println(builder.substring(0, builder.length()-2));
	}
	
}
