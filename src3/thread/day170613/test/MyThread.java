package thread.day170613.test;

import java.util.Scanner;

public class MyThread implements Runnable{//����һ���߳�������ʵ��Runnable�ӿ�
	Scanner sc = new Scanner(System.in);
	@Override
	public void run() {//��дrun�������߳�����
		
		for(int i=1;i<=100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1);//t1�̴߳�������״̬
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
//		System.out.println(sc.next());//t1�̴߳�������������״̬
	}

	//t1�̴߳�������״̬
}
