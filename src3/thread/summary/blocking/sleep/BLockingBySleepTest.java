package thread.summary.blocking.sleep;
/**
 * 对sleep阻塞的练习
 * @author Administrator
 *
 */
public class BLockingBySleepTest {
	public static void main(String[] args) {
		//创建对比的线程该线程不会满足条件  不进入阻塞状态
		BlockingBySleep b1 = new BlockingBySleep();
		b1.setName("对比线程");
		//该线程为阻塞的线程满足条件会进入阻塞状态
		BlockingBySleep b2 = new BlockingBySleep();
		b2.setName("sleep");
		
		//就绪 
		b1.start();
		b2.start();
		
	}
}
