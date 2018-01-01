package collection.day170502.test;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class RandomTest {
	@Test
	public void test1(){
		/**
		 * 返回一个伪随机数，它是取自此随机数生成器序列的、
		 * 在 0（包括）和指定值（不包括）之间均匀分布的 int 值
		 */
		for(int i=0;i<5;i++){
			Random r = new Random();
			int temp = r.nextInt(37);
			System.out.println(temp);
		}	
	}
	
}
