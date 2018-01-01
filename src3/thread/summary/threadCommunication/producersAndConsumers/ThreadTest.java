package thread.summary.threadCommunication.producersAndConsumers;

public class ThreadTest {
	public static void main(String[] args) {
		Workshop work = new Workshop(10);
		Producers producers = new Producers(work,"第一线程");
		Producers producers2 = new Producers(work,"第二线程");
		Consumers consumers = new Consumers(work,"第一线程");
		Consumers consumers2 = new Consumers(work,"第二线程");
		Consumers consumers3 = new Consumers(work,"第三线程");
		producers.start();
		producers2.start();
		consumers.start();
		consumers2.start();
		consumers3.start();
	}
}
