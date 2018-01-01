package thread.summary.synchronizedAndLock.lock.bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SetThread extends Thread{
	private BankCard bankCard;
	private Lock lock;
	private Condition getCondition;
	private Condition setCondition;
	private double money;
	
	public SetThread(BankCard bankCard,Lock lock,Condition getCondition,Condition setCondition,double money){
		this.bankCard = bankCard;
		this.lock = lock;
		this.getCondition = getCondition;
		this.setCondition = setCondition;
		this.money = money;
	}
	public SetThread(BankCard bankCard,String name,Lock lock,Condition getCondition,Condition setCondition,double money){
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
			setLock();
		}
	}
	public void setLock(){
		lock.lock();
		if(bankCard.getSum()==0){
			bankCard.set(money);
			System.out.println(getName()+"³É¹¦´æÈë"+money);
			getCondition.signal();
		}else{
			try {
				setCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		lock.unlock();
	}
}
