package test2;

public class Run extends B{
//	static {
//		System.out.println("Run类的静态初始化块");
//	}
	public static void main(String[] args){
		Run r = new Run();//实例化后才会执行普通初始化块和构造器
	}
	{
		System.out.println("Run类普通初始化块");
	}
	
	public Run(){
		this("run");//this调用当前类构造方法
		System.out.println("Run类空构造器");	
	}
	public Run(String s){
		System.out.println("Run。。。");
	}
}
class B extends C{
//	static {
//		System.out.println("B类的静态初始化块");
//	}
	{
		System.out.println("B类普通初始化块");
	}
	public B(){
		super("bbb");
	}
	public B(String s){
		
		
		System.out.println("B类传参构造器");
	}
}
class C{
//	static {
//		System.out.println("C类的静态初始化块");
//	}
	{
		System.out.println("C类普通初始化块");
	}
	public C(){
		this("sss");
		System.out.println("C类构造器");
	}
	public C(String s){
		System.out.println("C类传参构造器");
	}
}
