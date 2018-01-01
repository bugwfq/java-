package thread.producerAndConsumer.v1;

/**
 * ЩњВњеп
 * @author Administrator
 *
 */
public class Producer implements Runnable{
	private Kitchen k;
	public Producer(){}
	public Producer(Kitchen k){
		this.k = k;

	}
	@Override
	public void run() {
		for(int i = 0 ; i < 100; i ++){
			k.setK();
		}
	}
}
