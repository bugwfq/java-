package thread.summary.level;
/**
 * 本类主要针对线程优先级的练习
 * 线程等级的设置通过方法setPriority(1~10);来设定  范围在一到十之间
 * 
 * 
 * 通常线程的默认优先级为5
 * 
 * 
 * Thread类中提供了三个常量   MAX:10  ，MIN:1  , NORM:5 
 * @author Administrator
 *
 */
public class ThreadPriorityTest {
	public static void main(String[] args) {
		//新建线程优先级为10
		MyThread m1 = new MyThread("Thread.MAX_PRIORITY");
		m1.setPriority(Thread.MAX_PRIORITY);
		
		//新建线程优先级为1
		MyThread m2 = new MyThread("Thread.MIN_PRIORITY");
		m2.setPriority(Thread.MIN_PRIORITY);
		
		//新建线程优先级为默认5
		MyThread m3 = new MyThread("Thread.NORM_PRIORITY");
		m3.setPriority(Thread.NORM_PRIORITY);
		
		m2.start();
		m3.start();
		m1.start();
	}
}
