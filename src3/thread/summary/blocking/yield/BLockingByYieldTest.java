package thread.summary.blocking.yield;
/**
 * ��yield�ò�ʽ��������ϰ
 * @author Administrator
 *
 */
public class BLockingByYieldTest {
	public static void main(String[] args) {
		//�����Աȵ��̸߳��̲߳�����������  ����������״̬
		BlockingByYield b1 = new BlockingByYield();
		b1.setName("�Ա��߳�");
		//���߳�Ϊ�������߳������������������״̬
		BlockingByYield b2 = new BlockingByYield();
		b2.setName("yield");
		
		//���� 
		b1.start();
		b2.start();
		
	}
}
