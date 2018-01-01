package test.s4;

import java.util.LinkedList;

/**
 * 食堂
 * 
 * @author Administrator
 *
 */
public class FoodHouse {

	// 装馒头的容器
	private LinkedList<Food> foodList = new LinkedList<>();  // 只做了增加和删除操作
	
	/**
	 * 做馒头的方法(生产者[厨师])
	 */
	public synchronized void proFood(){
		
		if(foodList.size() == 10){
			// 通知学生线程
			notifyAll();
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else{  // 做馒头
			int id = IdTools.getId();
			Food food = new Food(id,"food"+id);  // [1,"food1"]
			foodList.add(food);
			System.out.println("厨师["+Thread.currentThread().getName()+"]生产馒头:"+food+"------>"+foodList.size());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 吃馒头的方法(消费者[学生])
	 */
	public synchronized void conFood(){
		
		if(foodList.size() == 0){
			// 通知所有厨师
			notifyAll();
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("学生["+Thread.currentThread().getName()+"]吃掉馒头:"+foodList.poll()+"--->"+foodList.size());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
