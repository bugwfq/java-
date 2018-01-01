package thread.summary.BlockingQueue.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Plant {
	private BlockingQueue<String> container;//����һ������
	private int index = 1;
	/**
	 * ����һ������������
	 * @param capacity
	 */
	public Plant(int capacity){
		 container = new LinkedBlockingQueue<>(capacity);
	}
	public BlockingQueue<String> getContainer() {
		return container;
	}
	public void setContainer(BlockingQueue<String> container) {
		this.container = container;
	}
	public void get() throws InterruptedException{
		if(container.size()>0){
			String str = container.take();
			System.out.println(Thread.currentThread().getName()+"�ɹ�����"+str);
			index--;
		}
		
	}
	public void set() throws InterruptedException{
		if(container.size()<container.remainingCapacity()){
			String str = "��"+index++;
			container.put(str);
			System.out.println(Thread.currentThread().getName()+"�ɹ�����"+str);
		}
		
	}
}
