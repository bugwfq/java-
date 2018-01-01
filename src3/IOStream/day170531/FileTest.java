package IOStream.day170531;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class FileTest {
	//@Test
	public void test1() throws IOException{
		File file = new File("src3/day170531/note.txt");
		if(!file.exists()){
			file.createNewFile();
		}
	}
	
	//@Test
	public void test2(){
		File file1 = new File("E:\\javacode");//Ŀ¼
		File file2 = new File("src3/day170531/note.txt");//�ļ�
		File file3 = new File("src3/day170531","note.txt");//�ļ�
		
		/*boolean bool1 = file1.isDirectory();
		boolean bool2 = file2.isDirectory();
		boolean bool3 = file3.isDirectory();*/
		
		boolean bool1 = file1.isFile();
		boolean bool2 = file2.isFile();
		boolean bool3 = file3.isFile();
		
		System.out.println(bool1);
		System.out.println(bool2);
		System.out.println(bool3);
	}
	
	//@Test
	public void test3(){
		File file = new File("src3/day170531/note.txt");
		String path = "src3"+file.separator+"day170531"+file.separator+"note.txt";
		File file2 = new File(path);
		boolean bool = file2.exists();
		System.out.println(bool);
	}
	
	//@Test
	public void test4() throws IOException{
		File file = new File("src3/day170531/note.txt");
		String name = file.getName();//�����ļ�����·����
		System.out.println(name);//note.txt
		
		String path = file.getPath();
		System.out.println(path);//src3\day170531\note.txt
		
		String absPath = file.getAbsolutePath();
		System.out.println(absPath);//E:\Eclipse�����ռ�\eclipse\work\src3\day170531\note.txt
		
		File file1 = file.getAbsoluteFile();
		String abPath = file1.getPath();
		System.out.println(abPath);//E:\Eclipse�����ռ�\eclipse\work\src3\day170531\note.txt
		
		String parent = file.getParent();
		System.out.println(parent);//src3\day170531
		
		File file2 = new File("src3/day170531/note1.txt");
		if(!file2.exists()){
			file2.createNewFile();
		}
		
		File file3 = new File("src3/day170531/note2.txt");
		boolean bool = file2.renameTo(file3);//������
		System.out.println(bool);
	}
	
	@Test
	public void test5(){
		File file = new File("D:\\Fblq.java");
		boolean bool = file.canRead();//�Ƿ�ɶ�
		boolean bool2 = file.canWrite();//�Ƿ��д
		System.out.println(bool);
		System.out.println(bool2);
		boolean bool3 = file.isHidden();//�Ƿ��������ļ�
		System.out.println(bool3);
	}
	
	//@Test
	public void test6(){
		File file = new File("src3/day170531/note2.txt");
		long length = file.length();//�����ļ����ݵĳ���
		System.out.println(length);
		
		long time = file.lastModified();//���ش˳���·������ʾ���ļ����һ�α��޸ĵ�ʱ��
		Date date = new Date(time);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
		
		
	}

}
