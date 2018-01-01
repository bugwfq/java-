package thread.day170613.test;

public class Thread5Test {
	public static void main(String[] args) {
		Thread5 t = new Thread5();
		t.setName("t");
		t.setDaemon(true);//将线程t设置成后台线程
		t.start();	
		
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
