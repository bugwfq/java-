package thread.day170616.test;

/**
 * ʳ���ࣨ��Դ��
 * @author Administrator
 *
 */
public class Food {
	private int count;//ʳ�����
	private boolean flag;
	
	public Food(int count){
		this.count = count;
	}
	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * ����
	 */
	public synchronized void getFood(int count){
		if(!flag){//û��ʳ��͵ȴ�
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("�߳�["+Thread.currentThread().getName()+"]����ʳ�"+count);
			//�޸ı��
			flag = false;
			notify();
		}
	}
	
	/**
	 * ����
	 */
	public synchronized void setFood(int count){
		if(flag){//��ʳ��͵�
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("�߳�["+Thread.currentThread().getName()+"]����ʳ�"+count);
			//�޸ı��
			flag = true;
			notify();
		}
	}
	
}
