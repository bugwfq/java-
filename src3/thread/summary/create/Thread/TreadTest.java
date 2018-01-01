package thread.summary.create.Thread;
/**
 * 创建线程的方法之一
 * 继承Thread线程类
 * @author Administrator
 *
 */
public class TreadTest {
	public static void main(String[] args) {
		//新建线程
		MyThread m = new MyThread();
		m.setName("set线程名");
		//新建线程
		m.start();
		MyThread m1 = new MyThread("利用父类构造其传入的线程名字");
		m1.start();
		
		
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(Thread.currentThread().getName() +"-"+i);
		}
	}
}
