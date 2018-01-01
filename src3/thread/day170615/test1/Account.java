package thread.day170615.test1;
/**
 * 账号类
 * @author Administrator
 *
 */
public class Account {
	private double fee;//余额
	
	public Account(){
		
	}
	
	public Account(double fee){
		this.fee = fee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public synchronized void getMoney(double fee){
		if(getFee()>0){//有钱
			setFee(getFee()-fee);
			System.out.println("线程["+Thread.currentThread().getName()+"]成功取走："+fee+"余额："+getFee());
			notify();//通知存钱线程
		}else{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void setMoney(double fee){
		if(getFee()>0){//有钱
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}else{
			setFee(getFee()+fee);
			System.out.println("线程["+Thread.currentThread().getName()+"]成功存入："+fee+"余额："+getFee());
			notify();//通知取钱线程
		}
	}
}
