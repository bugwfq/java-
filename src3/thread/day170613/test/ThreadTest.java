package thread.day170613.test;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread t = new MyThread();//�����߳�������
		Thread t1 = new Thread(t,"t1");//t1�̴߳��ڡ��½���״̬
		//�ı��߳����ȼ�
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();//����start������t1�̴߳���"����"״̬
	
		Thread t2 = new Thread(t,"t2");
		t2.setPriority(Thread.MAX_PRIORITY);//���ȼ��ߵĻ����Ȼ�ȡִ��ʱ��
		t2.start();
		
		System.out.println("t1-----------"+t1.getPriority());
		System.out.println("t2-----------"+t2.getPriority());
		System.out.println("Ĭ�����ȼ���"+Thread.currentThread().getPriority());
		
		System.out.println("������ȼ���"+Thread.MAX_PRIORITY);
		System.out.println("��С���ȼ���"+Thread.MIN_PRIORITY);
		System.out.println("Ĭ�����ȼ���"+Thread.NORM_PRIORITY);
		
	}
}
