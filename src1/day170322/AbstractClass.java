package day170322;

public abstract class AbstractClass {//抽象类的成员。。。
	private int x;
	public AbstractClass(){
		
	}
	static {
		
	}
	{
		
	}
	public void fun1(){//普通方法
		
	}
	
	class AA{//内部类
		
	}
	private enum X{//枚举
		
	}
	public AbstractClass(int x){
		this.x=x;
	}
	//抽象类中可以没有抽象方法，也可以有，但有抽象方法的类一定是抽象类
	public /*static*/ abstract void fun();//抽象方法没有方法体，不能用static修饰
	
}
class A extends AbstractClass{
	private int y=10;
	@Override
	public void fun() {
		// TODO Auto-generated method stub
		
	}
	public A(int x,int y){
		super(x);
		this.y = y;
	}
	
}
