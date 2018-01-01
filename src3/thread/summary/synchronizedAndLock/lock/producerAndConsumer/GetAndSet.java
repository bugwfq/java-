package thread.summary.synchronizedAndLock.lock.producerAndConsumer;

public class GetAndSet {
	public static void main(String[] args) {
		//创建容器
		Plant plant = new Plant(10);
		//新建线程
		Producer producer = new Producer(plant,"生产者1");
		Producer producer2 = new Producer(plant,"生产者2");
		Producer producer3 = new Producer(plant,"生产者3");
		Consumer consumer = new Consumer(plant,"消费者1");
		Consumer consumer2 = new Consumer(plant,"消费者2");
		//就绪
		producer.start();
		producer2.start();
		producer3.start();
		consumer.start();
		consumer2.start();
	}
}
