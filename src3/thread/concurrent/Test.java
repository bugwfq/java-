package thread.concurrent;

import java.util.concurrent.FutureTask;

public class Test {
	public static void main(String[] args) {
		//创建任务
		CallableTest cl = new CallableTest();
		//FutureTask类是Callable接口的包装类
		FutureTask<Integer> task = new FutureTask<Integer>(cl);
		//创建线程将任务传入线程构造器
		Thread t1 = new Thread(task);
		t1.start();
		
		for(int i = 0; i<=100; i++){
			System.out.println(Thread.currentThread().getName()+"-"+i);
		}
	}

}
