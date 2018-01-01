package thread.summary.threadCommunication.theHareAndTheTortoise;

public class TortoiseRunnable implements Runnable {
	private Runway runway;
	public TortoiseRunnable(Runway runway){
		this.runway = runway;
	}
	@Override
	public void run() {
		for(int i = 0 ; i <= runway.getRunway(); i ++){
			System.out.println(Thread.currentThread().getName()+"ÅÀÁË"+i+"Ã×");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == runway.getRunway()-1){
				synchronized(runway){
					runway.notify();
				}
			}
		}
	}
	
}
