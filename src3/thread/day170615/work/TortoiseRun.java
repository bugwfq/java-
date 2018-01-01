package thread.day170615.work;

public class TortoiseRun extends Thread{

	public TortoiseRun(){
		
	}
	
	public TortoiseRun(String name){
		super(name);
	
	}
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep(10);//同时起步
				System.out.println("乌龟跑了："+i+"米");
				if(i==100){
					System.out.println("乌龟到达终点！");
				}
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
}
