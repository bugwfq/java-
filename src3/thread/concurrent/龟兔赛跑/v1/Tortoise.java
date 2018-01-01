package thread.concurrent.實芤��變.v1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 拫實
 * @author Administrator
 *
 */
public class Tortoise extends Thread{
	private Road road;//變耋
	private Lock lock;
	private Condition con;
	public Tortoise( Road road,Lock lock,Condition con,String name){
		super(name);
		this.road = road;
		this.lock = lock;
		this.con = con;
	}
	@Override
	public void run() {
		for(int i = 0; i <= road.getLength(); i++){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName()+"變賸"+i+"譙");
			if(i == road.getLength()-1){
				lock.lock();
				try {
					con.signal();
				}finally{
					lock.unlock();
				}
			}
		}
	}
}
