package thread.summary.blocking.join;
/**
 * 对join阻塞的练习
 * @author Administrator
 *
 */
public class BLockingByJoinTest {
	public static void main(String[] args) {
		//创建对比的线程该线程不会满足条件  不进入阻塞状态
		BlockingByJoin b1 = new BlockingByJoin();
		b1.setName("对比线程");
		//该线程为阻塞的线程满足条件会进入阻塞状态
		BlockingByJoin b2 = new BlockingByJoin();
		b2.setName("sleep");
		
		//就绪 
		b1.start();
		b2.start();
		
	}
}
