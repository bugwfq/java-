package thread.summary.blocking.yield;

/**
 * 该类练习 yield让步式   状态下使线程进入阻塞状态
 * @author Administrator
 *
 */
public class BlockingByYield extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			
			if(getName().equals("yield") && i == 50  ){//当线程名为yield时会进入该方法
				//调用yield()线程让步方法该方法会让线程进入就绪状态  阻塞状态不明显
				yield();
			}
		}
	}
}
