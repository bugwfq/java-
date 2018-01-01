package exception.day170526;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyTest {
	public static void main(String[] args) throws FileNotFoundException {
		fun1();
	}
	
	public static void fun1() throws FileNotFoundException{
		System.out.println("1");
		System.out.println("2");
		try{
			System.out.println(1/0);//java.lang.ArithmeticException: / by zero
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
		
		System.out.println("3");
		
		File file = new File("c:\\\\test.txt");
		
//		try {
			FileInputStream fis = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
}
