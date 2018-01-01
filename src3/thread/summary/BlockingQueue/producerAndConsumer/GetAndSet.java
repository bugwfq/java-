package thread.summary.BlockingQueue.producerAndConsumer;


public class GetAndSet {
	public static void main(String[] args) {
		Plant plant = new Plant(10);
		
		Producer producer = new Producer(plant,"生产者");
		Consumer consumer = new Consumer(plant,"消费者");
		
		producer.start();
		consumer.start();
	}
}
