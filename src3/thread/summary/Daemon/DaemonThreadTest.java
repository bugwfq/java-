package thread.summary.Daemon;
/**
 * ������ϰ��̨�߳�
 * ��̨�̵߳����� setDaemon(true);
 * ���̳߳�Ϊ�ػ��߳�ʱ����ڸ��̵߳��������������ܺ�̨�߳��Ƿ�ִ����
 * @author Administrator
 *
 */
public class DaemonThreadTest {
	public static void main(String[] args) {
		//����ǰ̨�߳�
		DaemonThread d = new DaemonThread();
		d.setName("ǰ̨�߳�");
		
		//�����ػ��߳�
		DaemonThread d2 = new DaemonThread();
		d2.setName("daemon");
		
		d.start();
		
		//���ø��߳�Ϊ�ػ��̣߳���̨�̣߳�    ���ú�̨�߳�   setDaemon()����������� start()����ǰ��
		d2.setDaemon(true);
		d2.start();
	}
}
