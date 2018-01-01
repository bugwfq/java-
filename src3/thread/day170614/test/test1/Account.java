package thread.day170614.test.test1;

/**
 *账号类 
 * @author Administrator
 *
 */
public class Account {
	private double fee;//余额

	public Account() {
		super();
		
	}
	
	

	public Account(double fee) {
		super();
		this.fee = fee;
	}



	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	/*public synchronized void catchMoney(double fee){//加锁方式一：synchronized(同步方法)
		if(getFee()>=fee){
			System.out.println(Thread.currentThread().getName()+"成功取走"+fee+".");
			try {
				Thread.sleep(5000);//t1,t2,t3,t4都可能进入（阻塞）
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			setFee(getFee()-fee);
		}else {
			System.out.println("余额不足");
		}
	}*/
}
