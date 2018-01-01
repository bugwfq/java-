package thread.summary.BlockingQueue.producerAndConsumer;

public class Consumer extends Thread{
	private Plant plant;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
