package thread.concurrent;

import java.util.concurrent.FutureTask;

public class Test {
	public static void main(String[] args) {
		//��������
		CallableTest cl = new CallableTest();
		//FutureTask����Callable�ӿڵİ�װ��
		FutureTask<Integer> task = new FutureTask<Integer>(cl);
		//�����߳̽��������̹߳�����
		Thread t1 = new Thread(task);
		t1.start();
		
		for(int i = 0; i<=100; i++){
			System.out.println(Thread.currentThread().getName()+"-"+i);
		}
	}

}
