package thread.condition;

public class New {
	public static void main(String[] args) {
		//�߳��½�״̬�Ĳ鿴
		NewThread t = new NewThread();
		System.out.println(t.getState());//NEW �½�״̬
	}
}
class NewThread extends Thread{
	@Override
	public void run() {}
}