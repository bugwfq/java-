package thread.summary.Daemon;
/**
 * ����������ϰ��̨�̵߳��߳���
 * @author Administrator
 *
 */
public class DaemonThread extends Thread{
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			
			System.out.println(getName() +"-----"+i);
			//���߳���Ϊdeamonʱ�߳�ÿ�����н���˯0.1��
			if(getName().equals("daemon")){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
