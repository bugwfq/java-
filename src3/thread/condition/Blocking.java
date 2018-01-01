package thread.condition;

public class Blocking {
	public static void main(String[] args) {
		BlockingBase bb = new BlockingBase();
		
		BlockingThread bt1 = new BlockingThread(bb);
		bt1.start();
		BlockingThread bt2 = new BlockingThread(bb);
		bt2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bt1.getState());
		System.out.println(bt2.getState());
	}

}
class BlockingBase{
	Object obj1  = new Object();
	Object obj2  = new Object();
	public void test1(){
		synchronized(obj1){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj2){
				
				
			}
		}
	}
	public void test2(){
		synchronized(obj2){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj1){
				
				
			}
		}
	}
}
class BlockingThread extends Thread{
	public BlockingBase bb;
	public BlockingThread(){}
	public BlockingThread(BlockingBase bb){
		this.bb = bb;
	}
	@Override
	public void run() {
		bb.test1();
		bb.test2();
	}
}