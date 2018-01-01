package thread.summary.BlockingQueue.producerAndConsumer;
/**
 * ЩњВњеп
 * @author Administrator
 *
 */
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
