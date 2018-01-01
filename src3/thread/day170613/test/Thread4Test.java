package thread.day170613.test;

public class Thread4Test {
	public static void main(String[] args) throws InterruptedException {
		
		for(int i=1;i<=20;i++){
			if(i==10){
				Thread4 t = new Thread4();
				t.setName("t");
				
				t.start();
				t.join();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}
}
