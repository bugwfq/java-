package thread.concurrent;

import java.util.concurrent.Callable;
/**
 * 创建线程的第三种方式实现callable接口
 * @author Administrator
 *
 */
public class CallableTest implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {//类似与run方法但是可以添加返回值
		for(int i = 0; i<=100; i ++){
			System.out.println(Thread.currentThread().getName()+"  -  "+i);
		}
		return null;
	}

	
}
