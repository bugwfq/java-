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
		
		boolean bool = file.delete();//ɾ���ļ����ļ���
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
		String name = file.getName();//�ļ���
		System.out.println(name);
		
		String path = file.getPath();
		System.out.println(path);//·����
		
		String abPath = file.getAbsolutePath();//����·����
		System.out.println(abPath);
		
		String parent = file.getParent();
		System.out.println(parent);
		
	}
	
	//@Test
	public void test4(){
		File file = new File("src3/day170531/test/a.txt");
		boolean bool = file.canExecute();// ����Ӧ�ó����Ƿ����ִ�д˳���·������ʾ���ļ�
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
		
		long time = file.lastModified();//���һ���޸�ʱ��
		Date date = new Date(time);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
		
	}
	
	//@Test
	public void test6() throws IOException{
		File file = new File("src3/day170531/test");
		File temp = File.createTempFile("etetetet", ".iaeingg",file);//������ʱ�ļ�
	}
	
	//@Test
	public void test7(){
		File file = new File("src3/day170531/test/a/b/c");
		boolean bool = file.mkdirs();// �����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
		System.out.println(bool);
	}
	
	//@Test
	public void test8(){
		File file = new File("src3/day170531/test/c.txt");
		boolean bool = file.mkdir();//�����˳���·����ָ����Ŀ¼��
		System.out.println(bool);
	}
	
	//@Test
	public void test9(){
		
		String[] fs = new File("E:\\").list();//����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼
		for (String temp : fs) {
			System.out.println(temp);
		}
	}
	
	//@Test
	public void test10(){
		File[] fs = File.listRoots();// �г����õ��ļ�ϵͳ����
		for (File temp : fs) {
			System.out.println(temp);
		}
	}
	
	@Test
	public void test11(){
		//��ȡ���Ϲ�������ļ���·��
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
