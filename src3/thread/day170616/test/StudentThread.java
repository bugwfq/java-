package thread.day170616.test;
/**
 * ѧ���߳���
 * 
 * ��������������ģʽ	
		// ��������(ʳ��)[װʳ�װ��Ʒ������]
		// �������߳���(��ʦ)
		// �������߳���(ѧ��)
		// ������
ʳ�������������ķŽ�һ�����������������ƣ�������
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
