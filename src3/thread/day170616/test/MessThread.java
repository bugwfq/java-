package thread.day170616.test;
/**
 * 食堂类线程类
 * @author Administrator
 *
 */
public class MessThread extends Thread{
	private Food food;
	private int count;
	
	public MessThread(){
		
	}
	
	public MessThread(String name,Food food,int count){
		super(name);
		this.food = food;
		this.count = count;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			food.setFood(count);
		}
		
	}
	
	
}
