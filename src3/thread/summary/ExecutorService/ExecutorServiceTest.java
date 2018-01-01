package thread.summary.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);
		executor.submit(t4);
	}
}
