package thread.summary.blocking.yield;
/**
 * 对yield让步式阻塞的练习
 * @author Administrator
 *
 */
public class BLockingByYieldTest {
	public static void main(String[] args) {
		//创建对比的线程该线程不会满足条件  不进入阻塞状态
		BlockingByYield b1 = new BlockingByYield();
		b1.setName("对比线程");
		//该线程为阻塞的线程满足条件会进入阻塞状态
		BlockingByYield b2 = new BlockingByYield();
		b2.setName("yield");
		
		//就绪 
		b1.start();
		b2.start();
		
	}
}
