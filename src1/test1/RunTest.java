package test1;
//Object的静态初始化块(先定义先执行)->父类的静态初始化块(先定义先执行)->子类的静态初始化块(先定义先执行)
	// Object的普通初始化块(先定义先执行)->Object的构造器->父类的普通初始化块(先定义先执行)->父类的构造器
	// 子类的普通初始化块(先定义先执行)->子类的构造器
	
	// 对于使用this、super调用不同的构造器(按代码的执行顺序)
public class RunTest extends B{
	public RunTest(){
		super();
		System.out.println("R1");
	}
	static {
		System.out.println("R2");
	}
	static {
		System.out.println("R3");
	}
	{
		System.out.println("R4");
	}
	{
		System.out.println("R5");
	}
	public static void main(String[] args){
		RunTest t = new RunTest();
	}
}
	class B extends C{
		public B(){
			this("abc");
			System.out.println("B1");
		}
		public B(String s){
			super(s);
			System.out.println("B2");
		}
		static {
			System.out.println("B3");
		}
		static{
			System.out.println("B4");
		}
		{
			System.out.println("B5");
		}
		{
			System.out.println("B6");
		}
	}
	class C{
		public C(){
			System.out.println("C1");
		}
		public C(String s){
			System.out.println("C2");
		}
		static {
			System.out.println("C3");
		}
		static {
			System.out.println("C4");
		}
		{
			System.out.println("C5");
		}
		{
			System.out.println("C6");
		}
	}

