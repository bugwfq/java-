package day170322;

public class Test {
	/*7.�࣬�����࣬�ӿ�֮��ļ̳й�ϵ


	1.��������Ǽ̳й�ϵ�����̳У�
	2.����ӿ���ʵ�ֹ�ϵ����ʵ�֣�
	3.�ӿ���ӿ��Ǽ̳У�'��̳�'��
	4.��̳г����࣬������д������������г��󷽷�����ʵ�ֽӿڱ�����д��������з���
	5.������ʵ�ֽӿڿ��Բ���д�ӿ���ĳ��󷽷����ӿڼ̳нӿ�Ҳ���Բ�����д�ӿڵĳ��󷽷�*/
	
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
