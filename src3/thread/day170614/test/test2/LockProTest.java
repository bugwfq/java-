package thread.day170614.test.test2;

public class LockProTest {
	public static void main(String[] args) {
		LockPro pro = new LockPro();
		
		LockProThread t1 = new LockProThread("t1",pro);
		LockProThread t2 = new LockProThread("t2",pro);
		
		t1.start();
		t2.start();
	}
}
