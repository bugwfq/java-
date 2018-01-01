package thread.condition;
/**
 * 线程的死亡状态
 * @author Administrator
 *
 */
public class Terminated {
	public static void main(String[] args) throws InterruptedException {
		//新建线程
		TerminatedThread tt = new TerminatedThread();
		tt.start();
		//使主线程睡眠一秒钟后查看tt线程是否运行完
		Thread.sleep(100);
		System.out.println(tt.getState());//TERMINATED  死亡状态
	}
}
class TerminatedThread extends Thread{
	@Override
	public void run() {}
}