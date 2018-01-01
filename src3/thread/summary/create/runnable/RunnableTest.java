package thread.summary.create.runnable;
/**
 * 创建线程的方法之一
 * 实现Runnable接口
 * @author Administrator
 *
 */
public class RunnableTest {
	public static void main(String[] args) {
		//创建任务
		RunnableThread r = new RunnableThread();
		
		//新建线程  （新建状态）
		Thread t = new Thread(r,"构造器自定义线名程");
		Thread t1 = new Thread(r);
		t1.setName("set自定义线程名");
		//启动线程（就绪状态）
		t.start();
		t1.start();
		for(int i = 0 ; i < 100; i++){
			System.out.println(Thread.currentThread().getName()+"************************"+i);
		}
	}
}
