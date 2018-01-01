package thread.day170615.work;

public class RabbitRun extends Thread{

	public RabbitRun(){
		
	}
	
	public RabbitRun(String name){
		super(name);
	
	}
	
	@Override
	public void run() {
		for(int i=5;i<=100;i+=5){
			try {
				Thread.sleep(10);//同时起步
				System.out.println("兔子跑了："+i+"米");
				if(i==30){			
					Thread.sleep(50);
					System.out.println("休息会~");
				}else if(i==60){
					Thread.sleep(100);
					System.out.println("还能休息会，哇咔咔~");
				}else if(i==90){
					Thread.sleep(100);
					System.out.println("不好，乌龟要赢啦！/(ㄒoㄒ)/~~");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
}
