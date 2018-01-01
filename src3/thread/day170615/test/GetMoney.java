package thread.day170615.test;
/**
 * 取钱线程
 * @author Administrator
 *
 */
public class GetMoney extends Thread{
	private Account a;//账号
	private double fee;//取钱
	
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
