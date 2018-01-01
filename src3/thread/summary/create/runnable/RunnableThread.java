package thread.summary.create.runnable;

/**
 * 自定义类实现Runnable接口
 * 创建任务
 * @author Administrator
 *
 */
public class RunnableThread implements Runnable{

	@Override
	public void run() {//创建任务
		for(int i = 0 ; i < 100; i ++){
			System.out.println(Thread.currentThread().getName()+"-"+i);
		}
		
	}

}
