package day170322;

public abstract class AbstractClass {//������ĳ�Ա������
	private int x;
	public AbstractClass(){
		
	}
	static {
		
	}
	{
		
	}
	public void fun1(){//��ͨ����
		
	}
	
	class AA{//�ڲ���
		
	}
	private enum X{//ö��
		
	}
	public AbstractClass(int x){
		this.x=x;
	}
	//�������п���û�г��󷽷���Ҳ�����У����г��󷽷�����һ���ǳ�����
	public /*static*/ abstract void fun();//���󷽷�û�з����壬������static����
	
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
