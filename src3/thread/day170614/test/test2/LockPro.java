package thread.day170614.test.test2;

public class LockPro {
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	public void test1(){
		synchronized (obj1) {
			System.out.println(Thread.currentThread().getName()+"�ɹ���סobj1");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			synchronized(obj2){
				System.out.println(Thread.currentThread().getName()+"�ɹ���סobj2.���.");
			}
		}
	}
	
	public void test2(){
		synchronized(obj2){
			System.out.println(Thread.currentThread().getName()+"�ɹ���סobj2");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
			synchronized(obj1){
				System.out.println(Thread.currentThread().getName()+"�ɹ���סobj1.���");
			}
		}
	}
}
