package test.s4;

import java.util.LinkedList;

/**
 * ʳ��
 * 
 * @author Administrator
 *
 */
public class FoodHouse {

	// װ��ͷ������
	private LinkedList<Food> foodList = new LinkedList<>();  // ֻ�������Ӻ�ɾ������
	
	/**
	 * ����ͷ�ķ���(������[��ʦ])
	 */
	public synchronized void proFood(){
		
		if(foodList.size() == 10){
			// ֪ͨѧ���߳�
			notifyAll();
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else{  // ����ͷ
			int id = IdTools.getId();
			Food food = new Food(id,"food"+id);  // [1,"food1"]
			foodList.add(food);
			System.out.println("��ʦ["+Thread.currentThread().getName()+"]������ͷ:"+food+"------>"+foodList.size());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����ͷ�ķ���(������[ѧ��])
	 */
	public synchronized void conFood(){
		
		if(foodList.size() == 0){
			// ֪ͨ���г�ʦ
			notifyAll();
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("ѧ��["+Thread.currentThread().getName()+"]�Ե���ͷ:"+foodList.poll()+"--->"+foodList.size());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
