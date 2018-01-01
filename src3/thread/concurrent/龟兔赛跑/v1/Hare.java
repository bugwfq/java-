package thread.concurrent.龟兔赛跑.v1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 兔子
 * @author Administrator
 *
 */
public class Hare  extends Thread{
	private Road road;//跑道
	private Lock lock;
	private Condition con;
	public Hare( Road road,Lock lock,Condition con,String name){
		super(name);
		this.road = road;
		this.lock = lock;
		this.con = con;
	}
	@Override
	public void run() {
		
		for(int i = 0; i <= road.getLength(); i+=5){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName()+"跑了"+i+"米");
			if(i == road.getLength()>>1){
				lock.lock();
				try {
					con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		}
	}
}
