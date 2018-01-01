package collection.day170510;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		DoubleChain dc = new DoubleChain();
		dc.addElement("11");
		dc.addElement("22");
		dc.addElement("33");
		dc.addElement("44");
		dc.addElement("55");
		
		System.out.println(dc+"------------");
		String[] str = {"1","2","3"};
		
		dc.addAll(1, str);
		
		
		
	}
}
