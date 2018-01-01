package IOStream.day170605.work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class Hw {
	//@Test
	public void test1()throws Exception{
		/**
		 * 1.使用FileInputStream和FileOutputStream将两个文件的内容合并至一个新的文件，
		 * 新的文件将包含这两个文件的内容.
		 */
		File f1 = new File("src3/day170605/work/f1.txt");//文件1
		File f2 = new File("src3/day170605/work/f2.txt");//文件2
		File f = new File("src3/day170605/work/f.txt");//新文件
		
		FileInputStream fs1 = new FileInputStream(f1);
		FileInputStream fs2 = new FileInputStream(f2);
		FileOutputStream fos = new FileOutputStream(f);
		int mark1 = 0;
		while((mark1=fs1.read())!=-1){//边读边写第一个文件
			fos.write(mark1);
		}
		
		int mark2 = 0;
		while((mark2=fs2.read())!=-1){//边读边写第二个文件
			fos.write(mark2);
		}
		
		fs1.close();
		fs2.close();
		fos.close();
	
	}
	
	//@Test
	public void test2() throws Exception{
		/**
		 * 2.在控制台输入一串字符串，然后将其分类，并完成字母大小写之间的转换。
		 * 通过File对象创建不同类型的文件，然后将其内容保存至不同的文件.
		 */
		
		File upperToLower = new File("src3/day170605/work/upperToLower.txt");
		File lowerToUpper = new File("src3/day170605/work/lowerToUpper.txt");
		File digit = new File("src3/day170605/work/digit.txt");
		File java = new File("src3/day170605/work/java.txt");
		File illegal = new File("src3/day170605/work/illegal.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(upperToLower));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(lowerToUpper));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(digit));
		BufferedWriter bw4 = new BufferedWriter(new FileWriter(java));
		BufferedWriter bw5 = new BufferedWriter(new FileWriter(illegal));
		int mark = 0;
		while(true){
			mark=br.read();
			char temp = (char)mark;
			
			if(Character.isUpperCase(temp)){//大写转小写并写入文件
				bw1.write(Character.toLowerCase(temp));
			}else if(Character.isLowerCase(temp)){//小写转大写并写入文件
				bw2.write(Character.toUpperCase(temp));
			}else if(Character.isDigit(temp)){//数字
				bw3.write(temp);
			}else if(!(Character.isJavaIdentifierStart(temp) || Character.isLetterOrDigit(temp))){//非法字符
				bw5.write(temp);
			}
			
			if(Character.isJavaIdentifierStart(temp)){
				bw4.write(temp);
			}
			if((char)mark =='\n' ){
				br.close();
				bw1.close();
				bw2.close();
				bw3.close();
				bw4.close();
				bw5.close();
				break;
			}
		}
	}
	
	//@Test
	public void test3()throws Exception{
		/**
		 * 3.假设D:/dir目录下放着10个文件,文件名为:file001.txt,file002,file003.txt......file10.txt。
		 * 请写一高效程序，将这10个文件的内容按文件名编号顺序合并成一个文件file.txt。 
		 */
		
		PrintWriter pw = new PrintWriter(new File("src3/day170605/work/dir/file.txt"));
		File file = new File("src3/day170605/work/dir");
		File[] fs = file.listFiles();//获取file路径下的所有文件及文件夹
		//遍历数组
		for (File temp : fs) {
			if(temp.getName().endsWith(".txt")){
				BufferedReader bf = new BufferedReader(new FileReader(temp));//将字符流与缓冲区连接
				String str = null;
				while((str=bf.readLine())!=null){//边读边写
					pw.write(str+"\n");
				}
				
			}
		}
		pw.flush();
		pw.close();
	}
	
	@Test
	public void test(){
		try {
			test4();
		} catch (Exception e) {
			try {
				System.setErr(new PrintStream(new File("src3/day170605/work/d/error.txt")));//重定向到err.txt文件
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
		
		//将文本写入指定文件内
		/*FileWriter fw = new FileWriter("src3/day170605/work/d/system.txt");
		fw.write("print the system\n易通软件\nexception");
		fw.close();*/
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170605/work/d/system.txt")));
		pw.print("print the system");
		pw.print("易通软件");
		pw.print("exception");
		pw.close();
		
		System.setIn(new FileInputStream("src3/day170605/work/d/system.txt"));
		
		System.setOut(new PrintStream(new File("src3/day170605/work/d/out.txt")));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();		
			System.out.println(str);
			if(str.equals("exception")){				
				throw new MyException("我是自定义的异常");
			}
		}
	}	
}

