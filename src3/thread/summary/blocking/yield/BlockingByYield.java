package thread.summary.blocking.yield;

/**
 * ������ϰ yield�ò�ʽ   ״̬��ʹ�߳̽�������״̬
 * @author Administrator
 *
 */
public class BlockingByYield extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			
			if(getName().equals("yield") && i == 50  ){//���߳���Ϊyieldʱ�����÷���
				//����yield()�߳��ò������÷��������߳̽������״̬  ����״̬������
				yield();
			}
		}
	}
}
