package exception.day170526;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class IteratorRemove {
	@Test
	public void test1(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		/*Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String s = iter.next();
			if(s.equals("5")){
				list.remove("5");//ConcurrentModificationException
			}
			
		}*/
		
		/*for (String s : list) {
			if(s.equals("5")){
				list.remove("5");//ConcurrentModificationException
			}
		}*/
		
		for(int i=0;i<list.size();i++){
			String s = list.get(i);
			if(s.equals("1")){
				list.remove("1");
			}
		}
		
		System.out.println(list);
	}
}
