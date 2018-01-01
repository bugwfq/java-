package thread.summary.BlockingQueue.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Plant {
	private BlockingQueue<String> container;//创建一个容量
	private int index = 1;
	/**
	 * 创建一定容量的容器
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
			System.out.println(Thread.currentThread().getName()+"成功消费"+str);
			index--;
		}
		
	}
	public void set() throws InterruptedException{
		if(container.size()<container.remainingCapacity()){
			String str = "第"+index++;
			container.put(str);
			System.out.println(Thread.currentThread().getName()+"成功生产"+str);
		}
		
	}
}
