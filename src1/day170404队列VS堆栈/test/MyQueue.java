package day170404队列VS堆栈.test;

import java.util.Scanner;

public class MyQueue {
	private String[] elements = new String[10];
	private int index = 0;
	private int length = 0;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 入队
	 */
	public void addElement(){
		System.out.println("请输入要入队的元素：");
		String data = sc.next();
		//实现动态扩容
		if(index == elements.length){
			String[] temp = new String[elements.length*2];
			for(int i=0;i<elements.length;i++){
				temp[i] = elements[i];
			}
		}
		elements[index] = data;
		index++;
		length++;
		System.out.println("入队成功！");
	}
	 /**
	  * 出队
	  */
	public void deleteElement(){
		if(length == 0){
			System.out.println("当前队列为空");
			return;
		}
		System.out.println("当前出队的元素是："+elements[0]);
		//将其他元素复制到新数组
		String[] temp = new String[elements.length-1];
		int tempIndex = 0;
		for(int i=1;i<index;i++){
			temp[tempIndex] = elements[i]; 
			tempIndex++;
		}
		elements = temp;
		index--;
		length--;
	}
	/**
	 * 查看单个元素
	 */
	public void querySingleElements(){
		if(length == 0){
			System.out.println("当前队列为空");
			return;
		}
		System.out.println("请输入要查看的队列元素：");
		String data = sc.next();
		boolean bool = false;
		for(int i=0;i<elements.length;i++){
			if(elements[i].equals(data)){
				bool = true;
				break;
			}
		}	
		if(bool==true){
			System.out.println("队列元素是："+data);
		}else{
			System.out.println("没找到要查看的队列元素");
		}
	}
	/**
	 * 查看长度
	 */
	public void length(){
		System.out.println("当前队列长度是："+length);
	}
	/**
	 * 查看队列所有元素
	 */
	public void elementsList(){
		if(length==0){
			System.out.println("当前队列为空");
			return;
		}
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(elements[i]+"->");
		}
		System.out.println("要查看的队列元素是："+builder.substring(0, builder.length()-2));
	}
}
