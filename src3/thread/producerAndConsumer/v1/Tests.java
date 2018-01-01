package thread.producerAndConsumer.v1;

public class Tests {
	public static void main(String[] args) {
		Kitchen k = new Kitchen();
		Producer p = new Producer(k);
		Consumer c = new Consumer(k);
		
		
		Thread t1 = new Thread(p);

		
		Thread t2 = new Thread(c);

		
		t1.start();


		t2.start();

	}
}
