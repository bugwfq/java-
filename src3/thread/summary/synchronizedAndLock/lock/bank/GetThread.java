package thread.summary.synchronizedAndLock.lock.bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class GetThread extends Thread{
	private BankCard bankCard;//银行卡对象
	private Lock lock;
	private Condition getCondition;
	private Condition setCondition;
	private double money;
	public GetThread(BankCard bankCard, Lock lock,Condition getCondition,Condition setCondition,double money){
		this.bankCard = bankCard;
		this.lock = lock;
		this.getCondition = getCondition;
		this.setCondition = setCondition;
		this.money = money;
	}
	public GetThread(BankCard bankCard,String name, Lock lock,Condition getCondition,Condition setCondition,double money){
		super(name);
		this.bankCard = bankCard;
		this.lock = lock;
		this.getCondition = getCondition;
		this.setCondition = setCondition;
		this.money = money;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 20 ; i ++){
			getLock();
		}
	}
	public void getLock(){
		lock.lock();
		if(bankCard.getSum()<money){
			try {
				getCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			bankCard.get(money);
			System.out.println(getName()+"成功取出"+money);
			setCondition.signal();
			
		}
		lock.unlock();
	}
}
