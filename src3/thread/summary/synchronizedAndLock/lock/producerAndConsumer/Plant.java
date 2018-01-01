package thread.summary.synchronizedAndLock.lock.producerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��������
 * @author Administrator
 *
 */
public class Plant {
	//��������
	private LinkedList<String> container = new LinkedList<String>();
	//����lock������
	private final Lock lock = new ReentrantLock();
	//����������
	private final Condition getCondition = lock.newCondition();
	private final Condition setCondition = lock.newCondition();
	//��������������
	private final int num;
	private int index=1;
	public Plant(int num){
		this.num = num;
	}
	public LinkedList<String> getContainer() {
		return container;
	}
	public void setContainer(LinkedList<String> container) {
		this.container = container;
	}
	/**
	 * ���������ķ���
	 * @throws InterruptedException
	 */
	public void set() throws InterruptedException{
		lock.lock();
		while(container.size()==num){
			getCondition.signalAll();
			setCondition.await();
			
		}
			String str = "��"+index+++"��";
			container.add(str);
			System.out.println(Thread.currentThread().getName()+"�ɹ�����"+str);
		
		lock.unlock();
	}
	public void get() throws InterruptedException{
		lock.lock();
		while(container.size() == 0){
			setCondition.signalAll();
			getCondition.await();
			
		}
			String str = container.remove();
			System.out.println(Thread.currentThread().getName()+"�ɹ�����"+str);
		
		lock.unlock();
	}
}
