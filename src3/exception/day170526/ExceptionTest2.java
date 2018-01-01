package exception.day170526;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class ExceptionTest2 {
	
	public static void main(String[] args) {
		fun1();
	}
	
	
	private static void fun1(){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("src\\sdf\\ccc.sdfjl")));
		} catch (FileNotFoundException e) {
			//用于保存错误日志（方法一：）
			/*File file = new File("src3/day170526/err.log");
			try {
				PrintStream ps = new PrintStream(file);
				e.printStackTrace(ps);//将错误信息输出到控制台
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}*/
			
//			e.printStackTrace();//方法二：将错误信息输出到控制台
			
			/*String msg = e.getMessage();
			System.err.println(msg);*///方法三：获取错误信息 ，输出到控制台
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("hello world");
	}
}
