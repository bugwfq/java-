package thread.summary.blocking.sleep;

/**
 * 该类练习 sleep() 状态下使线程进入阻塞状态
 * @author Administrator
 *
 */
public class BlockingBySleep extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			
			if(getName().equals("sleep") && i == 50  ){//当线程名为sleep时会进入该方法
				System.out.println(getName()+"线程沉睡十秒");
				//调用睡眠方法设置时间为十秒
				try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
