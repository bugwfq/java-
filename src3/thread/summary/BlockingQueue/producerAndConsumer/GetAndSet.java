package thread.summary.BlockingQueue.producerAndConsumer;


public class GetAndSet {
	public static void main(String[] args) {
		Plant plant = new Plant(10);
		
		Producer producer = new Producer(plant,"������");
		Consumer consumer = new Consumer(plant,"������");
		
		producer.start();
		consumer.start();
	}
}
