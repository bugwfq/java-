package thread.summary.synchronizedAndLock.synchronizedtest.function;
/**
 * 抢票线程  主要字段有  
 * ticket 车票实体
 * num  预购票数
 * count  实际购票数
 * @author Administrator
 *
 */
public class BuyTickets extends Thread{
	private Ticket ticket;//车票
	private int num;
	private int count;
	public BuyTickets(Ticket ticket,int num){
		this.ticket = ticket;
		this.num = num;
	}
	public BuyTickets(Ticket ticket,String name,int num){
		super(name);
		this.ticket = ticket;
		this.num = num;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	@Override
	public void run() {
		for(int i = 0 ; i <num; i ++){
			
			if(!ticket.get()) break;
			System.out.println(getName()+"成功抢票一张");
			setCount(getCount()+1);
			
		}
		System.out.println(getName()+"预购票数"+num+"实际抢票"+count);
	}
}
