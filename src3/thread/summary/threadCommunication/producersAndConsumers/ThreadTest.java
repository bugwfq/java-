package thread.summary.threadCommunication.producersAndConsumers;

public class ThreadTest {
	public static void main(String[] args) {
		Workshop work = new Workshop(10);
		Producers producers = new Producers(work,"��һ�߳�");
		Producers producers2 = new Producers(work,"�ڶ��߳�");
		Consumers consumers = new Consumers(work,"��һ�߳�");
		Consumers consumers2 = new Consumers(work,"�ڶ��߳�");
		Consumers consumers3 = new Consumers(work,"�����߳�");
		producers.start();
		producers2.start();
		consumers.start();
		consumers2.start();
		consumers3.start();
	}
}
