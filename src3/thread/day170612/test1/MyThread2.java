package thread.day170612.test1;

import java.util.LinkedList;

public class MyThread2 {
	public static void main(String[] args) {
		Thread2 t2 = new Thread2();
		Thread t = new Thread(t2,"t2");
		Thread tr1 = new Thread(t2,"tr1");
		Thread tr2 = new Thread(t2,"tr2");
		Thread tr3 = new Thread(t2,"tr3");
		
		t.start();
		tr1.start();
		tr2.start();
		tr3.start();
		
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
}
