package IOStream.day170602.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class MyFiles2 {
	private static int codeNum = 0;//代码行数
	private static int noteNum = 0;//注释行数
	private static int blankNum = 0;//空白行数
	
	
	/**
	 * 根据指定路径获取所有.java文件
	 * @param file
	 */
	public static void getFiles(File file){
		File[] fs = file.listFiles();//获取该目录下所有文件和文件夹
		if(fs==null){
			return;
		}
		//遍历数组
		for (File temp : fs) {
			if(temp.isFile() && temp.getName().endsWith(".java")){
				isJava(temp);
			}else{
				getFiles(temp);
			}
		}
	}

	
	/**
	 * 统计java文件里的代码行数、注释行数、空白行数
	 * @param temp
	 */
	private static void isJava(File temp) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(temp));
			String str = null;
			try {
				while((str=br.readLine())!=null){
					if(str.matches("\\s*")){//空白行
						blankNum++;
					}else if(str.contains("/*") || str.contains("//")){//注释行
						noteNum++;
					}else{//代码行
						codeNum++;
					}
				}
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\Eclipse工作空间\\eclipse\\work");
		if(file.isDirectory()){//目录
			getFiles(file);
		}else{//文件
			if(file.isFile() && file.getName().endsWith(".java")){
				isJava(file);
			}
		}
		
		System.out.println("代码行数："+codeNum+"注释行数:"+noteNum+"空行："+blankNum);
	}
}
