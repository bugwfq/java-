package thread.summary.ThreadLocal;

/**
 * �������Ըñ������߳�
 * @author Administrator
 *
 */
public class ThreadLocalThread extends Thread{
	
	//�����иñ���Ϊ���ԵĶ���  
	private ThreadLocalUser tu;
	//���ܸö��� ��֤ ����һ������
	public ThreadLocalThread(ThreadLocalUser tu){
		this.tu = tu;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i <= 10 ; i ++){
			System.out.println(tu.getLocal() +"----------"+i);
			if(i == 6){
				tu.setLocal("��ֵ�ɹ���");
			}
			
			if(i == 9){
				tu.removeName();
			}
		}
	}
	
}
