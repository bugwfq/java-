package thread.summary.synchronizedAndLock.lock.producerAndConsumer;

public class GetAndSet {
	public static void main(String[] args) {
		//��������
		Plant plant = new Plant(10);
		//�½��߳�
		Producer producer = new Producer(plant,"������1");
		Producer producer2 = new Producer(plant,"������2");
		Producer producer3 = new Producer(plant,"������3");
		Consumer consumer = new Consumer(plant,"������1");
		Consumer consumer2 = new Consumer(plant,"������2");
		//����
		producer.start();
		producer2.start();
		producer3.start();
		consumer.start();
		consumer2.start();
	}
}
