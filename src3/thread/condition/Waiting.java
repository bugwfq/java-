package thread.condition;

public class Waiting {
	public static void main(String[] args) {
		WaitingThreadByJoin wtj = new WaitingThreadByJoin(Thread.currentThread());
		wtj.start();
		try {
			wtj.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用 Wait方法使线程
		WaitingThreadByWait  wtw = new WaitingThreadByWait ();

		wtw.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(wtw.getState());
		
	}
}

class WaitingThreadByWait extends Thread{
	private Object obj = new Object();
	@Override
	public void run() {
		synchronized(obj){
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class WaitingThreadByJoin extends Thread{
	private Thread t;
	public WaitingThreadByJoin(){}
	public WaitingThreadByJoin(Thread t){
		this.t = t;
	}
	@Override
	public void run() {
		for(int i = 0; i <= 10; i ++){
			System.out.println(getName()+":"+i);
		}
		System.out.println("main线程的状态："+t.getState());
	}
}