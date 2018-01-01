package thread.day170615.test;
/**
 * 账号类
 * @author Administrator
 *
 */
public class Account {
	private double fee;//余额
	private boolean flag;//是否有钱

	public Account() {
		super();
		
	}

	public Account(double fee,boolean flag) {
		super();
		this.fee = fee;
		this.flag = flag;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public synchronized void getMoney(double fee){
		if(!flag){//没钱
			try {
				wait();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}else{//有钱
			setFee(getFee()-fee);//修改余额
			System.out.println("线程["+Thread.currentThread().getName()+"]成功取走："+fee+",余额："+getFee());			
			flag = false;//没钱
			notify();
		}
	}	
	
	public synchronized void setMoney(double fee){
		if(flag){//有钱
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}else{
			setFee(getFee()+fee);
			System.out.println("线程["+Thread.currentThread().getName()+"]成功存入："+fee+",余额："+getFee());			
			flag = true;//有钱
			notify();
		}
		
	}
	
}
