package day170404队列VS堆栈.work;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		MyQueue mq = new MyQueue();
		int mark;
		while(true){
			System.out.println("1.入队2.出队3.查看队列长度4.查看单个队列元素5.查看所有队列元素0.退出");
			mark = sc.nextInt();
			if(mark==1){
				mq.addUser();
			}else if(mark==2){
				mq.deleteUser();
			}else if(mark==3){
				mq.length();
			}else if(mark==4){
				mq.querySingleUser();
			}else if(mark==5){
				mq.userList();
			}else{
				System.exit(0);
			}
		}
	}
	@Test
	public void test2(){
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack();
		int mark;
		while(true){
			System.out.println("1.入栈2.出栈3.查看栈的长度4.查看栈内元素0.退出");
			mark = sc.nextInt();
			if(mark==1){
				ms.addUser();
			}else if(mark==2){
				ms.deleteUser();
			}else if(mark==3){
				ms.length();
			}else if(mark==4){
				ms.userList();;
			}else{
				System.exit(0);
			}
		}
	}
}
