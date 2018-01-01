package thread.day170614.test.test1;

/**
 * 取钱线程
 * @author Administrator
 *
 */
public class CatchMoneyThread extends Thread{
	
	private Account account;//要取钱的账号
	private double fee;//要取的余额

	
	public CatchMoneyThread(String name,Account account, double fee) {
		super(name);
		this.account = account;
		this.fee = fee;
	}


	/**
	 * 线程任务：取钱
	 */
	@Override
	public void run() {
//		account.catchMoney(fee);
		synchronized (account) {//同步代码块加锁，锁可以是任意对象，但必须唯一!!
			if(account.getFee()>=fee){
				System.out.println("线程["+getName()+"]成功取走了："+fee);
				account.setFee(account.getFee()-fee);
			}else{
				System.out.println("余额不足");
			}
		}
				
	}
}
