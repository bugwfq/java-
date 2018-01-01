package collection.day170512.work;

public class MyTest {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		System.out.println(list);
		
		String[] s1 = {"6","7","8"};
		list.addAll(s1);
		System.out.println(list);
		
		String[] s2 = {"11","22","33","11","22"};
		list.addAll(3, s2);
		System.out.println(list);
		
//		list.remove("11");
//		System.out.println(list);
		String[] s3 = {"11","22","33"};
		list.removeAll(s3);
		System.out.println(list);
	}
}
