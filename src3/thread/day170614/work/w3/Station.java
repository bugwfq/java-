package thread.day170614.work.w3;
/**
 * 车站类
 * @author Administrator
 *
 */
public class Station {
	private int count;//余票
	private int index = 1;
	
	public Station() {
	
	}
	
	public Station(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public synchronized void catchTicket(){
		if(getCount()>=1){
			System.out.println("线程["+Thread.currentThread().getName()+"]成功买到第"+index+"张票");
			//修改余票
			setCount(getCount()-1);
			index++;
		}else{
			System.out.println("线程["+Thread.currentThread().getName()+"]余票不足");
		}
	}
	
}
