package thread.summary.Daemon;
/**
 * 该类练习后台线程
 * 后台线程的设置 setDaemon(true);
 * 当线程成为守护线程时后会在该线程的死亡下死亡不管后台线程是否执行完
 * @author Administrator
 *
 */
public class DaemonThreadTest {
	public static void main(String[] args) {
		//创建前台线程
		DaemonThread d = new DaemonThread();
		d.setName("前台线程");
		
		//创建守护线程
		DaemonThread d2 = new DaemonThread();
		d2.setName("daemon");
		
		d.start();
		
		//设置该线程为守护线程（后台线程）    设置后台线程   setDaemon()方法必须放在 start()方法前面
		d2.setDaemon(true);
		d2.start();
	}
}
