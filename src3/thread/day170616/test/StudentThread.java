package thread.day170616.test;
/**
 * 学生线程类
 * 
 * 生产者与消费者模式	
		// 生产车间(食堂)[装食物，装成品的容器]
		// 生产者线程类(厨师)
		// 消费者线程类(学生)
		// 测试类
食堂生产（生产的放进一个容器，有数量限制）和消费
 * @author Administrator
 *
 */
public class StudentThread extends Thread{
	private Food food;
	private int count;
	
	public StudentThread(){
		
	}
	
	public StudentThread(String name,Food food,int count){
		super(name);
		this.food = food;
		this.count = count;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			food.getFood(count);	
		}
	
	}
	
}
