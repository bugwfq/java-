package thread.summary.threadCommunication.producersAndConsumers;
/**
 * 消费者类
 * @author Administrator
 *
 */
public class Consumers  extends Thread{
	private Workshop workshop;
	
	public Consumers (Workshop workshop){
		this.workshop = workshop;
	}
	public Consumers (Workshop workshop,String name){
		super(name);
		this.workshop = workshop;
	}
	@Override
	public void run() {
		while(true){
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void consume() throws InterruptedException{
		synchronized(workshop){
			while(workshop.getIndex() == 0){
				workshop.notifyAll();
				workshop.wait();
			}
			workshop.get();
			
		}
	}
}
