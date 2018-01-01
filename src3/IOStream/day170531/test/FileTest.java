package IOStream.day170531.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class FileTest {
	//@Test
	public void test1() throws IOException{
		File file = new File("src3/day170531/test/a");
		/*if(!file.exists()){
			file.createNewFile();
		}*/
		
		boolean bool = file.delete();//删除文件或文件夹
		System.out.println(bool);
	}
	
	//@Test
	public void test2(){
		File file1 = new File("src3/day170531/test/a.txt");
		File file2 = new File(new File("src3/day170531/test"),"a.txt");
		File file3 = new File("src3/day170531/test","a.txt");
		
		boolean b1 = file1.exists();
		boolean b2 = file2.exists();
		boolean b3 = file3.exists();
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
	
	//@Test
	public void test3(){
		File file = new File("src3/day170531/test/a.txt");
		String name = file.getName();//文件名
		System.out.println(name);
		
		String path = file.getPath();
		System.out.println(path);//路径名
		
		String abPath = file.getAbsolutePath();//绝对路径名
		System.out.println(abPath);
		
		String parent = file.getParent();
		System.out.println(parent);
		
	}
	
	//@Test
	public void test4(){
		File file = new File("src3/day170531/test/a.txt");
		boolean bool = file.canExecute();// 测试应用程序是否可以执行此抽象路径名表示的文件
		System.out.println(bool);
		
		boolean b1 = file.canRead();
		System.out.println(b1);
		boolean b2 = file.canWrite();
		System.out.println(b2);
		
		boolean b3 = file.isHidden();
		System.out.println(b3);
		
	}
	
	//@Test
	public void test5(){
		File file = new File("src3/day170531/test/a.txt");
		long l = file.length();
		System.out.println(l);
		
		long time = file.lastModified();//最后一次修改时间
		Date date = new Date(time);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
		
	}
	
	//@Test
	public void test6() throws IOException{
		File file = new File("src3/day170531/test");
		File temp = File.createTempFile("etetetet", ".iaeingg",file);//创建临时文件
	}
	
	//@Test
	public void test7(){
		File file = new File("src3/day170531/test/a/b/c");
		boolean bool = file.mkdirs();// 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		System.out.println(bool);
	}
	
	//@Test
	public void test8(){
		File file = new File("src3/day170531/test/c.txt");
		boolean bool = file.mkdir();//创建此抽象路径名指定的目录。
		System.out.println(bool);
	}
	
	//@Test
	public void test9(){
		
		String[] fs = new File("E:\\").list();//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录
		for (String temp : fs) {
			System.out.println(temp);
		}
	}
	
	//@Test
	public void test10(){
		File[] fs = File.listRoots();// 列出可用的文件系统根。
		for (File temp : fs) {
			System.out.println(temp);
		}
	}
	
	@Test
	public void test11(){
		//获取符合规则的子文件或路径
		File file = new File("src3/day170531");
		File[] fs = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
			
				return pathname.getName().endsWith(".java");
			}
		});
		
		for (File temp : fs) {
			System.out.println(temp);
			
		}
	}
	
}
