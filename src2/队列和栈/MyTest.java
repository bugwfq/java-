package ���к�ջ;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	Scanner input=new Scanner(System.in);
//	@Test
	public void test1(){
		MyQueue queue=new MyQueue();
		while(true){
			System.out.println("��ѡ��\r\n1.���\r\n2.����\r\n3.�鿴����\r\n4.�鿴����\r\n5.�鿴����\r\n6.�˳�");
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
				System.out.println("���г���Ϊ"+queue.length());
			}else{
				System.exit(0);
			}
		}
	}
	@Test
	public void test2(){
		MyStack stack=new MyStack();
		while(true){
			System.out.println("��ѡ��\r\n1.��ջ\r\n2.��ջ\r\n3.�鿴����\r\n4.�鿴����\r\n5.�鿴����\r\n6.�˳�");
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
				System.out.println("ջ����Ϊ"+stack.length());
			}else{
				System.exit(0);
			}
		}
	}
}
