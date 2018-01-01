package IOStream.day170610;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class Hw4 {
/**
 * 4.在d:盘下先用代码生成个一个system.txt文件,里面有三行文本,如下
	print the system
	易通软件
	exception
	通过System类的in重定向,从控制台读取这个system.txt文件,并且用并把读取
到的文件内容用System的out重定向输出到d:/out.txt文件中,当读取到exception的时候
,请抛出一个自定义异常,异常的错误的信息是:"我是自定义的异常",把这个异常信息通过
System的err的重定向输出到d:/error.txt文件
	(考点:File,自定义异常,System里面的in ,out ,err重定
向,PrintStream,Writer,FileWriter)

 */
	
	@Test
	public void test1(){
		try {
			test();
		} catch (FileNotFoundException e) {
			try {
				System.setErr(new PrintStream(new File("src3/IO流/day170610/err.txt")));
				System.err.println(e.getMessage());
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test() throws FileNotFoundException{
	
		PrintWriter pw = new PrintWriter(new File("src3/IO流/day170610/system.txt"));
		pw.println("print the system");
		pw.println("易通软件");
		pw.println("exception");
		pw.flush();
		pw.close();
		
		System.setIn(new FileInputStream(new File("src3/IO流/day170610/system.txt")));
		System.setOut(new PrintStream(new File("src3/IO流/day170610/out.txt")));
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			String str = sc.next();
			System.out.print(str);
			
			if(str.equals("exception")){
				throw new MyException("自定义异常");
			}
		}
		
	}
}
