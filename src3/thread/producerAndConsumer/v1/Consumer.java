package thread.producerAndConsumer.v1;

/**
 * @author Administrator
 *
 */
public class Consumer implements Runnable{
	private Kitchen k;
	public Consumer(){}
	public Consumer(Kitchen k){
		this.k = k;

	}
	@Override
	public void run() {
		for(int i = 0 ; i < 100; i ++){
			k.getK();
		}
		
	}
}
