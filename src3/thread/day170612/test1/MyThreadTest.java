package thread.day170612.test1;

public class MyThreadTest {
	public static void main(String[] args) {
		//����һ���߳�
		MyThread t1 = new MyThread();
		t1.setName("b");//�޸��߳���
		t1.start();//�����߳�
		
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
