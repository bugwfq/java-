package thread.day170612.test1;
/**
 * �����̵߳ķ�����ʵ��Runnable�ӿ�
 * @author Administrator
 *
 */
public class Thread2 implements Runnable{

	//��д��ߵ�run������ִ������
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}
	
}
