package thread.day170615.test;
/**
 * ȡǮ�߳�
 * @author Administrator
 *
 */
public class GetMoney extends Thread{
	private Account a;//�˺�
	private double fee;//ȡǮ
	
	public GetMoney(){
		
	}
	
	public GetMoney(String name,Account a,double fee){
		super(name);
		this.a = a;
		this.fee = fee;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			a.getMoney(fee);
		}		
	}

}
