package thread.day170616.test;

public class Test {
	public static void main(String[] args) {
		Food food = new Food(100);
		MessThread m = new MessThread("ʳ��",food,10);
		StudentThread s = new StudentThread("ѧ��",food,10);
		
		m.start();
		s.start();
		
	}
}
