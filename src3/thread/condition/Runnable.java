package thread.condition;

public class Runnable {
	public static void main(String[] args) {
		//�߳�����״̬�Ĳ鿴
		System.out.println("��main�߳̿�Ϊִ�е��߳�");
		
		//�鿴main�̵߳�״̬
		System.out.println(Thread.currentThread().getState());//RUNNABLE ����״̬
	}
}
