package thread.summary.blocking.join;
/**
 * ��join��������ϰ
 * @author Administrator
 *
 */
public class BLockingByJoinTest {
	public static void main(String[] args) {
		//�����Աȵ��̸߳��̲߳�����������  ����������״̬
		BlockingByJoin b1 = new BlockingByJoin();
		b1.setName("�Ա��߳�");
		//���߳�Ϊ�������߳������������������״̬
		BlockingByJoin b2 = new BlockingByJoin();
		b2.setName("sleep");
		
		//���� 
		b1.start();
		b2.start();
		
	}
}
