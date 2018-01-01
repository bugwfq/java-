package thread.summary.create.callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int temp = 0; 
		for(int i = 0; i <= 100; i++){
			System.out.println(Thread.currentThread().getName()+"-"+i);
		}
		return temp ; 
	}
	
}
