package thread.day170613.test;

public class Thread4 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
