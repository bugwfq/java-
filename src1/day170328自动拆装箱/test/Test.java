package day170328�Զ���װ��.test;

public class Test {
	//�����������װ��֮���ת��(�Զ�װ�䣬�Զ����䣻��������xxxValue����)
	
	
//	@org.junit.Test
	public void test1(){//��������ת��װ��
		//1.�Զ�װ��
		Integer i = 100;		
		//2.valueOf����
		int j = 10;
		Integer j1 = Integer.valueOf(j);
		int i1 = 10;
		Integer i2 = new Integer(i1);//3.������
	} 
//	@org.junit.Test
	public void test2(){//��װ��ת��������
		//1.�Զ�����
		Integer i1 = new Integer(10);
		int j1;
		j1 = i1;
		//2.intValue����
		Integer j2 = new Integer(10);
		int i2 = j2.intValue();
			
	}
//	@org.junit.Test
	public void test3(){
		System.out.println(0.0/0.0);//����NaN
		Double d1 = new Double(0.0/0.0);
		
		System.out.println(d1.isNaN());
		System.out.println(Double.NaN);
		System.out.println(Double.isInfinite(1/0.0));
		
	}
	@org.junit.Test
	public void test4(){
		//�жϱ����Ƿ�����������
		Double d1 = new Double(1/0.0);//�������
		System.out.println(d1.isInfinite());
		System.out.println(Double.isInfinite(d1));
		Double d2 = new Double(-1/0.0);//�������
		System.out.println(d2.isInfinite());
		System.out.println(Double.isInfinite(d2));
		//�жϱ����Ƿ��Ƿ���
		Double d3 = new Double(0.0/0.0);
		System.out.println(d3);
		System.out.println(Double.isNaN(d3));
		
		System.out.println(Double.NEGATIVE_INFINITY);//�������
		System.out.println(Double.POSITIVE_INFINITY);//�������
		
		int i = 1000;
		System.out.println("0b"+Integer.toBinaryString(i));//������
		System.out.println("0"+Integer.toOctalString(i));//�˽���
		System.out.println("0x"+Integer.toHexString(i));//ʮ����
		
		
		
		System.out.println("I like "
				+ "java");//����д��System.out.println("I like
								//java");
	}
}
