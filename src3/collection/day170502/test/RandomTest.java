package collection.day170502.test;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class RandomTest {
	@Test
	public void test1(){
		/**
		 * ����һ��α�����������ȡ�Դ���������������еġ�
		 * �� 0����������ָ��ֵ����������֮����ȷֲ��� int ֵ
		 */
		for(int i=0;i<5;i++){
			Random r = new Random();
			int temp = r.nextInt(37);
			System.out.println(temp);
		}	
	}
	
}
