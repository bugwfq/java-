package thread.day170616;

public class ResourceDemo {
	public static void main(String[] args) {
		//1.������Դ(ͬһ��Դ)
		Resource r = new Resource();
		//2.��������
		Input i = new Input(r);
		Output o = new Output(r);
		//3.�����߳�
		Thread t1 = new Thread(i);
		Thread t2 = new Thread(o);
		
		//4.�����߳�
		t1.start();
		t2.start();
		
	}
}
