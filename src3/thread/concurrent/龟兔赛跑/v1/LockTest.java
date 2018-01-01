package thread.concurrent.��������.v1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args) {
		Road r = new Road(100);
		Lock lock = new ReentrantLock();
		Condition con = lock.newCondition();
		Hare h = new Hare(r,lock,con,"����");
		Tortoise t = new Tortoise(r,lock,con,"�ڹ�");
		
		h.start();
		t.start();
		
	}
}
