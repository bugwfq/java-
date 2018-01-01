package thread.summary.blocking.join;

/**
 * 该练习join 状态下使线程进入阻塞状态
 * @author Administrator
 *
 */
public class BlockingByJoin extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			//当线程名为join内部时让阻塞更加明显
			if(getName().equals("join内部")){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 当循环到50的时候如果是join线程则进入        并新建线程调用join方法
			if(getName().equals("join") && i == 50){
				BlockingByJoin b = new BlockingByJoin();
				b.setName("join内部");
				b.start();
				try {
					b.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			// 当循环到50的时候如果是join线程则进入        并新建线程不调用join方法
			if(getName().equals("对比线程") && i == 50){
				BlockingByJoin b = new BlockingByJoin();
				b.setName(getName()+"内部");
				b.start();
			}
			
		}
	}
}
