package thread.summary.synchronizedAndLock.lock.bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GetAndSetMoney {
	public static void main(String[] args) {
		BankCard bankCard = new BankCard(0);
		//����lock������
		Lock lock = new ReentrantLock();
		//����������
		Condition setCondition = lock.newCondition();
		Condition getCondition = lock.newCondition();
		//�½��߳�
		GetThread get = new GetThread(bankCard,"ȡǮ�߳�",lock,getCondition,setCondition,800.00);
		SetThread set = new SetThread(bankCard,"��Ǯ�߳�", lock ,getCondition,setCondition,800.00 );
		//�����߳�
		get.start();
		set.start();
	}
}
