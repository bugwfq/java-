package thread.day170616.test;

/**
 * 食物类（资源）
 * @author Administrator
 *
 */
public class Food {
	private int count;//食物的量
	private boolean flag;
	
	public Food(int count){
		this.count = count;
	}
	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * 消费
	 */
	public synchronized void getFood(int count){
		if(!flag){//没有食物就等待
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("线程["+Thread.currentThread().getName()+"]消费食物："+count);
			//修改标记
			flag = false;
			notify();
		}
	}
	
	/**
	 * 生产
	 */
	public synchronized void setFood(int count){
		if(flag){//有食物就等
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("线程["+Thread.currentThread().getName()+"]生产食物："+count);
			//修改标记
			flag = true;
			notify();
		}
	}
	
}
