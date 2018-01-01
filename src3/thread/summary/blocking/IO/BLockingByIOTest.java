package thread.summary.blocking.IO;
/**
 * 对IO阻塞的练习
 * @author Administrator
 *
 */
public class BLockingByIOTest {
	public static void main(String[] args) {
		//创建对比的线程该线程不会满足条件  不进入阻塞状态
		BlockingByIO b1 = new BlockingByIO();
		b1.setName("对比线程");
		//该线程为阻塞的线程满足条件会进入阻塞状态
		BlockingByIO b2 = new BlockingByIO();
		b2.setName("IO");
	
		//就绪 
		b1.start();
		b2.start();
		
	}
}
