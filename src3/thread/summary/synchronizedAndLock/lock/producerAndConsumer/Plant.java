package thread.summary.synchronizedAndLock.lock.producerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产车间
 * @author Administrator
 *
 */
public class Plant {
	//创建容器
	private LinkedList<String> container = new LinkedList<String>();
	//创建lock锁机制
	private final Lock lock = new ReentrantLock();
	//创建监视器
	private final Condition getCondition = lock.newCondition();
	private final Condition setCondition = lock.newCondition();
	//创建的容器容量
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
	 * 用于生产的方法
	 * @throws InterruptedException
	 */
	public void set() throws InterruptedException{
		lock.lock();
		while(container.size()==num){
			getCondition.signalAll();
			setCondition.await();
			
		}
			String str = "第"+index+++"个";
			container.add(str);
			System.out.println(Thread.currentThread().getName()+"成功生产"+str);
		
		lock.unlock();
	}
	public void get() throws InterruptedException{
		lock.lock();
		while(container.size() == 0){
			setCondition.signalAll();
			getCondition.await();
			
		}
			String str = container.remove();
			System.out.println(Thread.currentThread().getName()+"成功消费"+str);
		
		lock.unlock();
	}
}
