package thread.condition;

public class Runnable {
	public static void main(String[] args) {
		//线程运行状态的查看
		System.out.println("将main线程看为执行的线程");
		
		//查看main线程的状态
		System.out.println(Thread.currentThread().getState());//RUNNABLE 运行状态
	}
}
