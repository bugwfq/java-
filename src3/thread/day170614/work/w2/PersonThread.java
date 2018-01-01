package thread.day170614.work.w2;
/**
 * 人购票
 * @author Administrator
 *
 */
public class PersonThread extends Thread{

	private Station station;//车站
	private int index = 1;
	
	public PersonThread(){
		
	}
	
	public PersonThread(Station station){
		this.station = station;
	}
	
	//线程任务：购票
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			synchronized(station){
				if(station.getCount()>=1){//有票
					System.out.println("线程["+Thread.currentThread().getName()+"]成功买到第"+index+"张票");
					index++;
					//修改余票
					station.setCount(station.getCount()-1);
				}else{
					System.out.println("线程["+Thread.currentThread().getName()+"]余票不足");
				}
			}			
		}
		
	}

}
