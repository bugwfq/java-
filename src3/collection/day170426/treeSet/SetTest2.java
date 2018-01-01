package collection.day170426.treeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class SetTest2 {
	@Test
	public void test1(){
//		Set<Person> personSet = new TreeSet<>(new MyComparator());
		//匿名内部类
		Set<Person> personSet = new TreeSet<>(new Comparator<Person>(){
			
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				if(o1.getId()>o2.getId()){
					return 1;
				}else if(o1.getId()<o2.getId()){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
		Person p1 = new Person(1,"p1");
		Person p2 = new Person(1,"p2");
		Person p3 = new Person(1,"p3");
		
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		
		System.out.println(personSet);
		System.out.println(personSet.size());
	}
	
}
/*class MyComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		if(o1.getId()>o2.getId()){
			return 1;
		}else if(o1.getId()<o2.getId()){
			return -1;
		}else{
			return 0;
		}
		
	}

	
	
}
*/