package thread.summary.create.callable;

import java.util.concurrent.FutureTask;

public class CallableTest {
	public static void main(String[] args) {
		//创建自定义类实现Callable接口
		CallableThread c = new CallableThread();
		//创建包装类FutureTask<T>实例  将重写的call()的对象传入FutureTask实例的构造器中
		FutureTask<Integer> f = new FutureTask<Integer>(c);
		
		//利用Thread（Runnable r）的构造方法新建线程
		Thread t = new Thread(f);
		
		//启动线程
		t.start();
		
		
		for(int i = 0 ; i < 100; i ++){
			System.out.println(Thread.currentThread().getName() +"-"+i);
		}
	}
}
