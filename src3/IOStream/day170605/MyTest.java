package IOStream.day170605;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1()throws Exception{
		/**
		 * 1.使用FileInputStream和FileOutputStream将两个文件的内容合并至一个新的文件，
		 * 新的文件将包含这两个文件的内容.
		 */
		FileInputStream fis = new FileInputStream(new File("src3/day170605/a.txt"));
		FileOutputStream fos = new FileOutputStream(new File("src3/day170605/c.txt"),true);// 追加到后面
		int mark = 0;
		while((mark=fis.read())!=-1){
			fos.write(mark);
		}
		
		mark = 0;
		fis = new FileInputStream(new File("src3/day170605/b.txt"));
		while((mark=fis.read())!=-1){
			fos.write(mark);
		}
		
		fis.close();
		fos.close();
		
	}
	
	//@Test
	public void test2()throws Exception{
		/**
		 * 2.在控制台输入一串字符串，然后将其分类，并完成字母大小写之间的转换。
		 * 通过File对象创建不同类型的文件，然后将其内容保存至不同的文件.
		 */
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//声明builder可变字符序列
		StringBuilder digit = new StringBuilder();//数字
		StringBuilder lower = new StringBuilder();//小写字母
		StringBuilder upper = new StringBuilder();//大写字母
		StringBuilder java = new StringBuilder();//java标示符
		StringBuilder others = new StringBuilder();//其他字符
		
		//将字符串转化为数组
		char[] cs = str.toCharArray();
		//遍历数组
		for (char c : cs) {
			if(Character.isDigit(c)){
				digit.append(c);
			}else if(Character.isLowerCase(c)){
				//小写转大写
				lower.append(Character.toUpperCase(c));
			}else if(Character.isUpperCase(c)){
				//大写转小写
				upper.append(Character.toLowerCase(c));
			}else if(Character.isJavaIdentifierPart(c)){
				java.append(c);
			}else {
				others.append(c);
			}
		}
		
		//分别写入文件中
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src3/day170605/digit.txt")));
		bw.write(digit.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/lower.txt")));
		bw.write(lower.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/upper.txt")));
		bw.write(upper.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/java.txt")));
		bw.write(java.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/others.txt")));
		bw.write(others.toString());
		bw.flush();
		
		bw.close();
	}
	
	//@Test
	public void test3()throws Exception{
		/**
		 * 3.假设D:/dir目录下放着10个文件,文件名为:file001.txt,file002,file003.txt......file10.txt。
		 * 请写一高效程序，将这10个文件的内容按文件名编号顺序合并成一个文件file.txt。 
		 */
		
		/*PrintWriter pw = new PrintWriter(new FileWriter(new File("src3/day170605/dir/file.txt")));
		File file = new File("src3/day170605/dir");
		File[] fs = file.listFiles();
		
		for (File temp : fs) {
			if(temp.getName().endsWith(".txt")){
				BufferedReader br = new BufferedReader(new FileReader(temp));
				String str = null;
				while((str=br.readLine())!=null){
					pw.write(str+"\n");
				}
			}
		}
		
		pw.flush();
		pw.close();
		*/
		
		PrintWriter pw = new PrintWriter(new FileWriter(new File("src3/day170605/dir/file.txt")));
		
		BufferedReader br = null;
		for(int i=1;i<=10;i++){
			String path = "src3/day170605/dir/file00"+i+".txt";
			File file = new File(path);
			br = new BufferedReader(new FileReader(file));
			String str = null;
			while((str=br.readLine())!=null){
				pw.println(str);
				pw.flush();
			}
			br.close();
		}
		
		pw.close();
	}
	
	@Test
	public void test(){
		try {
			test4();
		} catch (Exception e) {
			try {
				System.setErr(new PrintStream(new File("src3/day170605/d/err.txt")));
				System.err.println(e.getMessage());
			} catch (FileNotFoundException e1) {
				
				System.out.println("文件路径异常");
			}
			
		}
	}
	
	//@Test
	public void test4()throws Exception{
		/**
		 * 4.在d:盘下先用代码生成个一个system.txt文件,里面有三行文本,如下
		 * print the system
		 * 易通软件
		 * exception
		 * 通过System类的in重定向,从控制台读取这个system.txt文件,
		 * 并且用并把读取到的文件内容用System的out重定向输出到d:/out.txt文件中,
		 * 当读取到exception的时候,请抛出一个自定义异常,异常的错误的信息是:"我是自定义的异常",
		 * 把这个异常信息通过System的err的重定向输出到d:/error.txt文件
		 */
		
		File file = new File("src3/day170605/d/system.txt");
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.println("print the system");
		pw.println("易通软件");
		pw.println("exception");

		pw.close();
		
		System.setIn(new FileInputStream(file));//从键盘重定向到文件system.txt
		System.setOut(new PrintStream(new File("src3/day170605/d/out.txt")));//从控制台重定向到out.txt文件
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			String str = sc.next();
			System.out.print(str);//输出到文件out.txt
			
			if(str.equals("exception")){
				throw new MyException("我是自定义异常");
			}
		}
		
	}
}

class MyException extends RuntimeException{
	MyException(){
		super();
	}
	
	MyException(String message){
		super(message);
	}
}
