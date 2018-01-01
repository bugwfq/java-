package thread.summary.synchronizedAndLock.lock.producerAndConsumer;
/**
 * Ïû·ÑÕß
 * @author Administrator
 *
 */
public class Consumer extends Thread{
	private Plant plant ;
	public Consumer(Plant plant){
		this.plant = plant;
	}
	public Consumer(Plant plant,String name){
		super(name);
		this.plant = plant;
	}
	@Override
	public void run() {
		while(true){
			try {
				plant.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
