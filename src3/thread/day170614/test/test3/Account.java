package thread.day170614.test.test3;
/**
 * 账号类
 * @author Administrator
 *
 */
public class Account {
	private double fee;//余额

	public Account() {
	
	}

	public Account(double fee) {

		this.fee = fee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	/**
	 * 取钱
	 * @param fee
	 */
	
	public synchronized void catchMoney(double fee){
		if(getFee()>=fee){
			System.out.println("线程["+Thread.currentThread().getName()+"]成功取走："+fee);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e){
			
				e.printStackTrace();
			}
			setFee(getFee()-fee);
		}else{
			System.out.println("余额不足");
		}
		
	}
	
}
