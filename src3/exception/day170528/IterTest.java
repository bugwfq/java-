package exception.day170528;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		System.out.println(list);
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
//			iter.remove();//IllegalStateException
			
			String s = iter.next();
			/*if(s.equals("4")){
				list.remove("4");//删除倒数第二个不会发生异常
			}*/
			
			if(s.equals("1")){
				list.remove("1");//ConcurrentModificationException
			}
			System.out.println(s);
			
		}
		System.out.println(list);
	}
}
