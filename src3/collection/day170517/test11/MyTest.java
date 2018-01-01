package collection.day170517.test11;

import org.junit.Test;

public class MyTest {
	/*@Test
	public void test1(){
		String[] a = {"1","2","3","4","5","6","7","8","9","10","11"};
		String[] b = {"8","9","10","11","12","13","14","15"};
		
//		System.arraycopy(a, 2, b, 4, 4);
		
		System.arraycopy(a, 3, a, 3 + 1,
                7 - 3);
		for(String s : a){
			System.out.println(s);
		}
		
		MyArrayList ml = new MyArrayList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		System.out.println(ml);
	}*/
	
	public static void main(String[] args) {
		MyArrayList ml = new MyArrayList();
		ml.add("1");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		String[] strs = ml.getDatas();
		for (String temp : strs) {
			if(temp!=null){
				System.out.println(temp);
			}			
		}
		
		ml.add(2, "0");
		System.out.println(ml);
		
		MyArrayList ml2 = new MyArrayList();
		ml2.addAll(ml);
		String[] strs2 = ml2.getDatas();
		for (String temp : strs2) {
			if(temp!=null){
				System.out.println(temp);
			}
		}
		
		System.out.println("--------------");
		
		ml.addAll(3, ml2);
		String[] str = ml.getDatas();
		for (String temp : str) {
			if(temp!=null){
				System.out.println(temp);
			}
		}
		
		
		
		
	}
}
