package thread.day170613.test;

public class Thread3 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
