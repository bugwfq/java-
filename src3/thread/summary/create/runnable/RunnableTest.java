package thread.summary.create.runnable;
/**
 * �����̵߳ķ���֮һ
 * ʵ��Runnable�ӿ�
 * @author Administrator
 *
 */
public class RunnableTest {
	public static void main(String[] args) {
		//��������
		RunnableThread r = new RunnableThread();
		
		//�½��߳�  ���½�״̬��
		Thread t = new Thread(r,"�������Զ���������");
		Thread t1 = new Thread(r);
		t1.setName("set�Զ����߳���");
		//�����̣߳�����״̬��
		t.start();
		t1.start();
		for(int i = 0 ; i < 100; i++){
			System.out.println(Thread.currentThread().getName()+"************************"+i);
		}
	}
}
