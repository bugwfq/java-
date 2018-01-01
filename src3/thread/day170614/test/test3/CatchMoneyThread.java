package thread.day170614.test.test3;
/**
 * 取钱线程
 * @author Administrator
 *
 */
public class CatchMoneyThread extends Thread{
	private Account account;//（谁取钱）账号
	private double fee;//取多少
	
	public CatchMoneyThread(String name,Account account,double fee){
		super(name);
		this.account = account;
		this.fee = fee;
	}
	
	//线程任务：取钱
	@Override
	public void run() {
		account.catchMoney(fee);
	}
}
