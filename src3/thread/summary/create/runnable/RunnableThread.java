package thread.summary.create.runnable;

/**
 * �Զ�����ʵ��Runnable�ӿ�
 * ��������
 * @author Administrator
 *
 */
public class RunnableThread implements Runnable{

	@Override
	public void run() {//��������
		for(int i = 0 ; i < 100; i ++){
			System.out.println(Thread.currentThread().getName()+"-"+i);
		}
		
	}

}
