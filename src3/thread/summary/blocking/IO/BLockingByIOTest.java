package thread.summary.blocking.IO;
/**
 * ��IO��������ϰ
 * @author Administrator
 *
 */
public class BLockingByIOTest {
	public static void main(String[] args) {
		//�����Աȵ��̸߳��̲߳�����������  ����������״̬
		BlockingByIO b1 = new BlockingByIO();
		b1.setName("�Ա��߳�");
		//���߳�Ϊ�������߳������������������״̬
		BlockingByIO b2 = new BlockingByIO();
		b2.setName("IO");
	
		//���� 
		b1.start();
		b2.start();
		
	}
}
