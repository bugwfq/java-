package thread.summary.blocking.sleep;

/**
 * ������ϰ sleep() ״̬��ʹ�߳̽�������״̬
 * @author Administrator
 *
 */
public class BlockingBySleep extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			
			if(getName().equals("sleep") && i == 50  ){//���߳���Ϊsleepʱ�����÷���
				System.out.println(getName()+"�̳߳�˯ʮ��");
				//����˯�߷�������ʱ��Ϊʮ��
				try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
