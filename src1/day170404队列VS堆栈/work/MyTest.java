package day170404����VS��ջ.work;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		MyQueue mq = new MyQueue();
		int mark;
		while(true){
			System.out.println("1.���2.����3.�鿴���г���4.�鿴��������Ԫ��5.�鿴���ж���Ԫ��0.�˳�");
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
			System.out.println("1.��ջ2.��ջ3.�鿴ջ�ĳ���4.�鿴ջ��Ԫ��0.�˳�");
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
