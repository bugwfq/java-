package thread.day170616.test;

public class Test {
	public static void main(String[] args) {
		Food food = new Food(100);
		MessThread m = new MessThread("Ê³ÌÃ",food,10);
		StudentThread s = new StudentThread("Ñ§Éú",food,10);
		
		m.start();
		s.start();
		
	}
}
