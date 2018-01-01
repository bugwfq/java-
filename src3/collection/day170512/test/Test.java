package collection.day170512.test;

public class Test {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(7);
		
		System.out.println(list);//1,2,3,5,6,7
		
		Integer[] ss = {11,22,33};
		list.addAll(ss);
		System.out.println(list);//1,2,3,5,6,7,11,22,33
		
		list.addAll(2, ss);
		System.out.println(list);//1,2,11,22,33,3,5,6,7,11,22,33
		
		list.remove(7);
		System.out.println(list);//1,2,11,22,33,3,5,6,11,22,33
		
		list.removeAll(ss);
		System.out.println(list);//1,2,3,5,6
	}
}
