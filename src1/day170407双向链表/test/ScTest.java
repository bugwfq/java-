package day170407˫������.test;

import java.util.Scanner;

import org.junit.Test;

public class ScTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		DoubleChain chain = new DoubleChain();
		while(true){
			System.out.println("1.����2.��������3.��������4.ɾ��0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				chain.addNode();
			}else if(mark==2){
				chain.ltr();
			}else if(mark==3){
				chain.rtl();
			}else if(mark==4){
				
			}else{
				System.exit(0);
			}
		}
		
	}
}
