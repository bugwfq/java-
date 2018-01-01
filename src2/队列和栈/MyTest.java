package 队列和栈;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	Scanner input=new Scanner(System.in);
//	@Test
	public void test1(){
		MyQueue queue=new MyQueue();
		while(true){
			System.out.println("请选择：\r\n1.入队\r\n2.出队\r\n3.查看单个\r\n4.查看所有\r\n5.查看长度\r\n6.退出");
			int menu=input.nextInt();
			if(menu==1){
				queue.addUser();
			}else if(menu==2){
				queue.deleteUser();
			}else if(menu==3){
				queue.queryUser();
			}else if(menu==4){
				queue.queryUserAll();
			}else if(menu==5){
				System.out.println("队列长度为"+queue.length());
			}else{
				System.exit(0);
			}
		}
	}
	@Test
	public void test2(){
		MyStack stack=new MyStack();
		while(true){
			System.out.println("请选择：\r\n1.入栈\r\n2.出栈\r\n3.查看单个\r\n4.查看所有\r\n5.查看长度\r\n6.退出");
			int menu=input.nextInt();
			if(menu==1){
				stack.addUser();
			}else if(menu==2){
				stack.deleteUser();
			}else if(menu==3){
				stack.queryUser();
			}else if(menu==4){
				stack.queryUserAll();
			}else if(menu==5){
				System.out.println("栈长度为"+stack.length());
			}else{
				System.exit(0);
			}
		}
	}
}
