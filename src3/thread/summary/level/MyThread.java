package thread.summary.level;
/**
 * �Զ����̼̳߳�Thread��
 * @author Administrator
 *
 */
public class MyThread extends Thread{
	public MyThread(){}
	public MyThread(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 100; i ++){
			System.out.println(getName()+"---"+i);
		}
	}
	
}
