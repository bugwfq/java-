package thread.day170615.work.work2;

public class RunTest {
	public static void main(String[] args) {
		Object obj = new Object();
		
		Rabbit r = new Rabbit("ÍÃ×Ó",obj);
		Tortoise t = new Tortoise("ÎÚ¹ê",obj);
		
		r.start(); 
		t.start();
	}
}
