package thread.day170613.test;
/**
 * sleep方法：会让线程处于阻塞状态
 * yield方法：会让线程处于就绪状态
 * @author Administrator
 *
 */
public class thread3Test {
	public static void main(String[] args) {
		
		
		for(int i=1;i<=20;i++){
			if(i==10){
				/*try {
					t1.sleep(1000);//阻塞
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				Thread3 t1 = new Thread3();
				t1.setName("t1");
				t1.setPriority(Thread.MAX_PRIORITY);
				
				t1.start();
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}
}
