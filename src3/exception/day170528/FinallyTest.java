package exception.day170528;

public class FinallyTest {
	public static void main(String[] args) {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		try{
			System.out.println(1/0);
		}catch (ArithmeticException e) {
			// TODO: handle exception
		}
		
		System.out.println("4");
		System.out.println("5");
		
		
		
	}
}
