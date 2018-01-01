package thread.day170612.test;

public class MyThreadTest {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.setName("t");
		t.start();
		
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
