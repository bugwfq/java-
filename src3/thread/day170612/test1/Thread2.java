package thread.day170612.test1;
/**
 * 创建线程的方法：实现Runnable接口
 * @author Administrator
 *
 */
public class Thread2 implements Runnable{

	//重写里边的run方法（执行任务）
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}
	
}
