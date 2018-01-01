package thread.summary.create.Thread;

public class MyThread extends Thread{
	public MyThread(){}
	public MyThread(String name){//利用父类构造器传入线程名
		super(name);
	}
	@Override
	public void run() {//创建任务
		for(int i  = 0; i < 100; i++){
			System.out.println(Thread.currentThread().getName()+"-"+i);
		}
	}
}
