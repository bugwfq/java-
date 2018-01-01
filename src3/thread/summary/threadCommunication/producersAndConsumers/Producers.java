package thread.summary.threadCommunication.producersAndConsumers;
/**
 * 生产者类
 * @author Administrator
 *
 */
public class Producers extends Thread{
	private Workshop workshop;
	public Producers(Workshop workshop){
		this.workshop = workshop;
	}
	public Producers(Workshop workshop,String name){
		super(name);
		this.workshop = workshop;
	}
	@Override
	public void run() {
		while(true){
			try {
				production();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void production() throws InterruptedException{
		synchronized(workshop){
			if(workshop.getIndex() < workshop.getObj().length){
				workshop.notifyAll();
				workshop.set();
			}else{
				workshop.wait();
			}	
		}
	}
}
