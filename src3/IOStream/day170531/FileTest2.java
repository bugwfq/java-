package IOStream.day170531;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.junit.Test;

public class FileTest2 {
	//@Test
	public void test1(){
		File file = new File("src3/day170531/a");
		boolean bool = file.delete();//删除文件或路径
		System.out.println(bool);
	}
	
	//@Test
	public void test2() throws IOException{
		File file1 = new File("src3/day170531");
		File file = File.createTempFile("etetetet", ".szyt",file1);//创建临时文件
		
	}
	
	//@Test
	public void test3(){
		/*File file = new File("src3/day170531/a.txt");		
		boolean bool = file.mkdir();*/ //创建此抽象路径名指定的目录
		File file = new File("src3/day170531/a/b/c");
		boolean bool = file.mkdirs();//可以创建多层文件夹
		System.out.println(bool);
		
	}
	//@Test 
	public void test4(){
		File file = new File("E:\\");
		/*String[] files = file.list();//列出File对象的所有子文件名和路径
		for (String temp : files) {
			System.out.println(temp);
		}*/
		
		File[] files = file.listFiles();//列出File对象的所有子文件名和路径
		for (File temp : files) {
			System.out.println(temp);
		}
	}
	
	//@Test
	public void test5(){
		File[] files = File.listRoots();
		/*列出系统所有的根路径
		 *  C:\
		 * D:\
		 * E:\*/

		for (File temp : files) {
			System.out.println(temp);
		}
	}
	
	@Test
	public void test6(){
		File file = new File("src3/day170531");
		File[] files = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
			
				return pathname.getName().endsWith(".java");
			}
		});
		
		for (File temp : files) {
			System.out.println(temp);
		}
	}
	
}
