package thread.day170614.test.test1;

/**
 * ȡǮ�߳�
 * @author Administrator
 *
 */
public class CatchMoneyThread extends Thread{
	
	private Account account;//ҪȡǮ���˺�
	private double fee;//Ҫȡ�����

	
	public CatchMoneyThread(String name,Account account, double fee) {
		super(name);
		this.account = account;
		this.fee = fee;
	}


	/**
	 * �߳�����ȡǮ
	 */
	@Override
	public void run() {
//		account.catchMoney(fee);
		synchronized (account) {//ͬ��������������������������󣬵�����Ψһ!!
			if(account.getFee()>=fee){
				System.out.println("�߳�["+getName()+"]�ɹ�ȡ���ˣ�"+fee);
				account.setFee(account.getFee()-fee);
			}else{
				System.out.println("����");
			}
		}
				
	}
}
