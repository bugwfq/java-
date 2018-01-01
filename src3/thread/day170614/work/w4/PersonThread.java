package thread.day170614.work.w4;

public class PersonThread implements Runnable{
	private Station station;
	private int index = 1;
	
	public PersonThread(){
		
	}
	
	public PersonThread(Station station){
		this.station = station;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			//同步代码块
			synchronized (station) {
				if(station.getCount()>=1){			
					System.out.println("线程["+Thread.currentThread().getName()+"]成功买到第"+index+"张票");
					index++;
					station.setCount(station.getCount()-1);	//修改余票	
				}else{
					System.out.println(Thread.currentThread().getName()+"余票不足");
				}
			}	
		}
		
	}

}
