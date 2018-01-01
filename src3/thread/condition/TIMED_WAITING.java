package thread.condition;

public class TIMED_WAITING {
	public static void main(String[] args) {
		TimedWaiting tw = new TimedWaiting();
		tw.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tw.getState());
	}
}
class TimedWaiting extends Thread{
	@Override
	public void run() {
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}