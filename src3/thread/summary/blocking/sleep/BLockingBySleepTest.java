package thread.summary.blocking.sleep;
/**
 * ��sleep��������ϰ
 * @author Administrator
 *
 */
public class BLockingBySleepTest {
	public static void main(String[] args) {
		//�����Աȵ��̸߳��̲߳�����������  ����������״̬
		BlockingBySleep b1 = new BlockingBySleep();
		b1.setName("�Ա��߳�");
		//���߳�Ϊ�������߳������������������״̬
		BlockingBySleep b2 = new BlockingBySleep();
		b2.setName("sleep");
		
		//���� 
		b1.start();
		b2.start();
		
	}
}
