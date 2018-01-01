package day170322;

public class Test {
	/*7.类，抽象类，接口之间的继承关系


	1.类与抽象是继承关系（单继承）
	2.类与接口是实现关系（多实现）
	3.接口与接口是继承（'多继承'）
	4.类继承抽象类，必须重写抽象类里的所有抽象方法；类实现接口必须重写里面的所有方法
	5.抽象类实现接口可以不重写接口里的抽象方法，接口继承接口也可以不用重写接口的抽象方法*/
	
}
class AB extends B{
	void fun(){
		
	}

	@Override
	void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void d() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e() {
		// TODO Auto-generated method stub
		
	}
}
class F implements C,D{

	@Override
	public void d() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e() {
		// TODO Auto-generated method stub
		
	}
	
}
 abstract class B implements C{
	abstract void b();
}
interface C extends D,E{
	void c();
}
interface D{
	
	void d();
}
interface E{
	void e();
}
