package thread.summary.create.callable;

import java.util.concurrent.FutureTask;

public class CallableTest {
	public static void main(String[] args) {
		//�����Զ�����ʵ��Callable�ӿ�
		CallableThread c = new CallableThread();
		//������װ��FutureTask<T>ʵ��  ����д��call()�Ķ�����FutureTaskʵ���Ĺ�������
		FutureTask<Integer> f = new FutureTask<Integer>(c);
		
		//����Thread��Runnable r���Ĺ��췽���½��߳�
		Thread t = new Thread(f);
		
		//�����߳�
		t.start();
		
		
		for(int i = 0 ; i < 100; i ++){
			System.out.println(Thread.currentThread().getName() +"-"+i);
		}
	}
}
