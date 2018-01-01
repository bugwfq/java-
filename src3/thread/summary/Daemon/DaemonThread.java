package thread.summary.Daemon;
/**
 * 该类用来练习后台线程的线程类
 * @author Administrator
 *
 */
public class DaemonThread extends Thread{
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			
			System.out.println(getName() +"-----"+i);
			//当线程名为deamon时线程每次运行将沉睡0.1秒
			if(getName().equals("daemon")){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
