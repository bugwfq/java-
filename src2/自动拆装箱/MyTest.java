package �Զ���װ��;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		/**
		 * ��������ת��װ��:1.�Զ�װ��2.������3.valueOf����
		 */
		Integer i = 10;
		
		Integer j = new Integer(i);
		
		int x = 100;
		Integer y = Integer.valueOf(x);
		
		//��װ��ת��������:1.�Զ�����2.intValue����
		
		Integer i1 = new Integer(10);
		int j1 = i1;
		
		Integer x1 = new Integer(100);
		int y1 = x1.intValue();
		
		/**
		 * String��������͵�ת��
		 */
		//��������תString(String.valueOf����)
		int i2 = 10;
		String s2 = String.valueOf(i2);
		System.out.println(s2);
		
		//Stringת��������(����������װ�����valueOf����)
		String s3 = "97";
		int i3 = Integer.valueOf(s3);
		int i4 = Integer.valueOf(s3);
		System.out.println("i3:"+i3+",i4:"+i4);
	}
}
