package thread.day170615.test;
/**
 * ��Ǯ�߳�
 * @author Administrator
 *
 */
public class SetMoney extends Thread{
	private Account a;//�˺�
	private double fee;//ȡǮ
	
	public SetMoney(){
		
	}
	
	public SetMoney(String name,Account a,double fee){
		super(name);
		this.a = a;
		this.fee = fee;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			a.setMoney(fee);
		}
		
	}
}
