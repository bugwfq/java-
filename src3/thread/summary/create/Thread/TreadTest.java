package thread.summary.create.Thread;
/**
 * �����̵߳ķ���֮һ
 * �̳�Thread�߳���
 * @author Administrator
 *
 */
public class TreadTest {
	public static void main(String[] args) {
		//�½��߳�
		MyThread m = new MyThread();
		m.setName("set�߳���");
		//�½��߳�
		m.start();
		MyThread m1 = new MyThread("���ø��๹���䴫����߳�����");
		m1.start();
		
		
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(Thread.currentThread().getName() +"-"+i);
		}
	}
}
