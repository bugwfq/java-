package day170404����VS��ջ.test;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		MyQueue mq = new MyQueue();
		while(true){
			System.out.println("1.���2.����3.�鿴����Ԫ��4.�鿴����5.�鿴��������Ԫ��0.�˳�");
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
			System.out.println("1.��ջ2.��ջ3.�鿴ջ������Ԫ��4.�鿴ջ����0.�˳�");
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
