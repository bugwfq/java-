package thread.day170614.test.test3;
/**
 * ȡǮ�߳�
 * @author Administrator
 *
 */
public class CatchMoneyThread extends Thread{
	private Account account;//��˭ȡǮ���˺�
	private double fee;//ȡ����
	
	public CatchMoneyThread(String name,Account account,double fee){
		super(name);
		this.account = account;
		this.fee = fee;
	}
	
	//�߳�����ȡǮ
	@Override
	public void run() {
		account.catchMoney(fee);
	}
}
