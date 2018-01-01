package test1;

public class TestFinal {
	final int x = 1000;//(final int x;)The blank final field x may not have been initialized
	public static void main(String[] args){
		TestFinal tf = new TestFinal();
		tf.fun1();
		
		System.out.println(tf.x);
	}
	public final void fun1(){
		int y = 100;
		System.out.println(y);
	}
//	public final void fun1(int x){
//		x = 1100;
//		System.out.println(x);
//	}
}
