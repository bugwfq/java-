package thread.summary.synchronizedAndLock.synchronizedtest.function;

public class Ticket {
	private int ticketNum;//车票个数
	
	public Ticket(int ticketNum){
		this.ticketNum = ticketNum;
	}
	/**
	 * 同步方法若抢票成功则返回true否则返回false
	 * @return
	 */
	public synchronized boolean get(){
		if(ticketNum == 0){
			System.out.println("车票已售完！");
			return false;
		}
		ticketNum--;
		return true;
	}
}
