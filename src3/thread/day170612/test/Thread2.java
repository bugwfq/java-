package thread.day170612.test;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}

}
