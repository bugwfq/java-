package thread.day170614.test.test2;

public class LockPro {
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	public void test1(){
		synchronized (obj1) {
			System.out.println(Thread.currentThread().getName()+"成功锁住obj1");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			synchronized(obj2){
				System.out.println(Thread.currentThread().getName()+"成功锁住obj2.完成.");
			}
		}
	}
	
	public void test2(){
		synchronized(obj2){
			System.out.println(Thread.currentThread().getName()+"成功锁住obj2");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
			synchronized(obj1){
				System.out.println(Thread.currentThread().getName()+"成功锁住obj1.完成");
			}
		}
	}
}
