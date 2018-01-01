package test.s4;

public class Test {

	public static void main(String[] args) {
		
		FoodHouse fh = new FoodHouse();
		
		Student s1 = new Student("stu1", fh);
		Student s2 = new Student("stu2", fh);
//		Student s3 = new Student("stu3", fh);
//		Student s4 = new Student("stu4", fh);
//		Student s5 = new Student("stu5", fh);
		
		FoodTeacher t1 = new FoodTeacher("t1", fh);
		FoodTeacher t2 = new FoodTeacher("t2", fh);
//		FoodTeacher t3 = new FoodTeacher("t3", fh);
		
		s1.start();
		t1.start();
		s2.start();
//		t3.start();
//		s3.start();
//		s4.start();
		t2.start();
//		s5.start();
		
	}
}
