package thread.condition;
/**
 * �̵߳�����״̬
 * @author Administrator
 *
 */
public class Terminated {
	public static void main(String[] args) throws InterruptedException {
		//�½��߳�
		TerminatedThread tt = new TerminatedThread();
		tt.start();
		//ʹ���߳�˯��һ���Ӻ�鿴tt�߳��Ƿ�������
		Thread.sleep(100);
		System.out.println(tt.getState());//TERMINATED  ����״̬
	}
}
class TerminatedThread extends Thread{
	@Override
	public void run() {}
}