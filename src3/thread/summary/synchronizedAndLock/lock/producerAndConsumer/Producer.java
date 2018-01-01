package thread.summary.synchronizedAndLock.lock.producerAndConsumer;

public class Producer extends Thread{
	private Plant plant;
	public Producer(Plant plant){
		this.plant = plant;
	}
	public Producer(Plant plant,String name){
		super(name);
		this.plant = plant;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				plant.set();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
