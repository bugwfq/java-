package thread.summary.synchronizedAndLock.lock.bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GetAndSetMoney {
	public static void main(String[] args) {
		BankCard bankCard = new BankCard(0);
		//创建lock锁机制
		Lock lock = new ReentrantLock();
		//创建监视器
		Condition setCondition = lock.newCondition();
		Condition getCondition = lock.newCondition();
		//新建线程
		GetThread get = new GetThread(bankCard,"取钱线程",lock,getCondition,setCondition,800.00);
		SetThread set = new SetThread(bankCard,"存钱线程", lock ,getCondition,setCondition,800.00 );
		//启动线程
		get.start();
		set.start();
	}
}
