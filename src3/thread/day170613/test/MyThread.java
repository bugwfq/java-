package thread.day170613.test;

import java.util.Scanner;

public class MyThread implements Runnable{//创建一个线程任务类实现Runnable接口
	Scanner sc = new Scanner(System.in);
	@Override
	public void run() {//重写run方法（线程任务）
		
		for(int i=1;i<=100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1);//t1线程处于阻塞状态
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
//		System.out.println(sc.next());//t1线程处于阻塞（挂起）状态
	}

	//t1线程处于死亡状态
}
