package day170404队列VS堆栈.test;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		MyQueue mq = new MyQueue();
		while(true){
			System.out.println("1.入队2.出队3.查看单个元素4.查看长度5.查看队列所有元素0.退出");
			int	mark = sc.nextInt();
			if(mark==1){
				mq.addElement();
			}else if(mark==2){
				mq.deleteElement();
			}else if(mark==3){
				mq.querySingleElements();
			}else if(mark==4){
				mq.length();
			}else if(mark==5){
				mq.elementsList();
			}else {
				System.exit(0);
			}
		}
	}
	
	@Test
	public void test2(){
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack();
		
		while(true){
			System.out.println("1.入栈2.出栈3.查看栈内所有元素4.查看栈长度0.退出");
			int mark = sc.nextInt();
			if(mark==1){
				ms.addElement();
			}else if(mark==2){
				ms.deleteElement();
			}else if(mark==3){
				ms.allElements();
			}else if(mark==4){
				ms.length();
			}else{
				System.exit(0);
			}
		}
	}
}
