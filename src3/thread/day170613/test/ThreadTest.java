package thread.day170613.test;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread t = new MyThread();//创建线程任务类
		Thread t1 = new Thread(t,"t1");//t1线程处于“新建”状态
		//改变线程优先级
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();//调用start方法，t1线程处于"就绪"状态
	
		Thread t2 = new Thread(t,"t2");
		t2.setPriority(Thread.MAX_PRIORITY);//优先级高的会优先获取执行时间
		t2.start();
		
		System.out.println("t1-----------"+t1.getPriority());
		System.out.println("t2-----------"+t2.getPriority());
		System.out.println("默认优先级："+Thread.currentThread().getPriority());
		
		System.out.println("最大优先级："+Thread.MAX_PRIORITY);
		System.out.println("最小优先级："+Thread.MIN_PRIORITY);
		System.out.println("默认优先级："+Thread.NORM_PRIORITY);
		
	}
}
