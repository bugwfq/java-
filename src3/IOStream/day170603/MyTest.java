package IOStream.day170603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class MyTest {
	private static final int BUFFER_SIZE = 1024;

	//@Test
	public void test1() throws IOException, InterruptedException{
		/**
		 * 将一个文件复制到另一个地方
		 * 1.读取源文件
		 * 2.将读到的原文件写到目的地
		 * 3.操作文本文件用字符流
		 * 4.关闭流资源
		 */
		FileReader fr = new FileReader("src3/day170603/MyTest.java");//搭建源文件与程序的管道（读入程序）
		FileWriter fw = new FileWriter("src3/day170603/mt.txt");//搭建程序与目的地文件的管道（写入文件）
		int mark = 0;
		while((mark=fr.read())!=-1){
			fw.write(mark);		//读一个字符写一个字符	
		}
		
		//关闭流资源
		fr.close();
		fw.close();
	}
	
	//@Test
	public void test2(){
		/**
		 * 按照数组读
		 */
		
		FileReader fr = null;
		FileWriter fw = null;
	
		try {
			fr = new FileReader("src3/day170603/MyTest.java");
			fw = new FileWriter("src3/day170603/mt.txt");
			char[] cs = new char[BUFFER_SIZE];
			int mark = 0;
			while((mark=fr.read(cs))!=-1){
				fw.write(cs, 0, mark);//边读边写（0：开始的位置，Mark：读到的字符数）
			}
		} catch (Exception e) {
			throw new RuntimeException("读写失败");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	public void test3() throws IOException{
		
		FileReader fr = new FileReader("src3/day170603/MyTest.java");
		BufferedReader br = new BufferedReader(fr);//缓冲区与文件流连接
		
		FileWriter fw = new FileWriter("src3/day170603/b.txt");
		BufferedWriter bw = new BufferedWriter(fw);//缓冲区与文件流连接
		
		String line = null;
		while((line = br.readLine())!=null){//边读边写
			bw.write(line);
			bw.newLine();//每写一次，换行一次
			bw.flush();//刷新一次
		}
			
		fr.close();
		fw.close();
		
		
	}
}
