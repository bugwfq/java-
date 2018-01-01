package thread.summary.blocking.join;

/**
 * ����ϰjoin ״̬��ʹ�߳̽�������״̬
 * @author Administrator
 *
 */
public class BlockingByJoin extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			//���߳���Ϊjoin�ڲ�ʱ��������������
			if(getName().equals("join�ڲ�")){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// ��ѭ����50��ʱ�������join�߳������        ���½��̵߳���join����
			if(getName().equals("join") && i == 50){
				BlockingByJoin b = new BlockingByJoin();
				b.setName("join�ڲ�");
				b.start();
				try {
					b.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			// ��ѭ����50��ʱ�������join�߳������        ���½��̲߳�����join����
			if(getName().equals("�Ա��߳�") && i == 50){
				BlockingByJoin b = new BlockingByJoin();
				b.setName(getName()+"�ڲ�");
				b.start();
			}
			
		}
	}
}
