package thread.summary.level;
/**
 * ������Ҫ����߳����ȼ�����ϰ
 * �̵߳ȼ�������ͨ������setPriority(1~10);���趨  ��Χ��һ��ʮ֮��
 * 
 * 
 * ͨ���̵߳�Ĭ�����ȼ�Ϊ5
 * 
 * 
 * Thread�����ṩ����������   MAX:10  ��MIN:1  , NORM:5 
 * @author Administrator
 *
 */
public class ThreadPriorityTest {
	public static void main(String[] args) {
		//�½��߳����ȼ�Ϊ10
		MyThread m1 = new MyThread("Thread.MAX_PRIORITY");
		m1.setPriority(Thread.MAX_PRIORITY);
		
		//�½��߳����ȼ�Ϊ1
		MyThread m2 = new MyThread("Thread.MIN_PRIORITY");
		m2.setPriority(Thread.MIN_PRIORITY);
		
		//�½��߳����ȼ�ΪĬ��5
		MyThread m3 = new MyThread("Thread.NORM_PRIORITY");
		m3.setPriority(Thread.NORM_PRIORITY);
		
		m2.start();
		m3.start();
		m1.start();
	}
}
