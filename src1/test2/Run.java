package test2;

public class Run extends B{
//	static {
//		System.out.println("Run��ľ�̬��ʼ����");
//	}
	public static void main(String[] args){
		Run r = new Run();//ʵ������Ż�ִ����ͨ��ʼ����͹�����
	}
	{
		System.out.println("Run����ͨ��ʼ����");
	}
	
	public Run(){
		this("run");//this���õ�ǰ�๹�췽��
		System.out.println("Run��չ�����");	
	}
	public Run(String s){
		System.out.println("Run������");
	}
}
class B extends C{
//	static {
//		System.out.println("B��ľ�̬��ʼ����");
//	}
	{
		System.out.println("B����ͨ��ʼ����");
	}
	public B(){
		super("bbb");
	}
	public B(String s){
		
		
		System.out.println("B�ഫ�ι�����");
	}
}
class C{
//	static {
//		System.out.println("C��ľ�̬��ʼ����");
//	}
	{
		System.out.println("C����ͨ��ʼ����");
	}
	public C(){
		this("sss");
		System.out.println("C�๹����");
	}
	public C(String s){
		System.out.println("C�ഫ�ι�����");
	}
}
