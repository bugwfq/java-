package thread.summary.threadCommunication.theHareAndTheTortoise;

public class HareRunnable implements Runnable{
	private Runway runway;
	public HareRunnable (Runway runway){
		this.runway = runway;
	}
	@Override
	public void run() {
		for(int i = 0 ; i <= runway.getRunway(); i += 5){
			System.out.println(Thread.currentThread().getName()+"ลÜมห"+i+"รื");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == runway.getRunway()>>1){
				synchronized(runway){
					try {
						runway.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
