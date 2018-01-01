package IOStream.day170602.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;
/**
 * 分别统计代码行数，注释行数，空行数
 * @author Administrator
 
 */
public class MyFiles {
	private static int lineNum = 0;//代码行数
	private static int noteNum = 0;//注释行数
	private static int blankNum = 0;//空行数
	
	private static void getFiles(File file){
		File[] fs = file.listFiles();//获取指定路径下的所有文件和文件夹
		if(fs==null){
			return;
		}
		//遍历数组
		for (File temp : fs) {//递归出口：该File对象是文件
			if(temp.isFile() && temp.getName().endsWith(".java")){
				isJava(temp);
			}else{
				getFiles(temp);
			}
		}
		
	}

	private static void isJava(File temp) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(temp));
			try {
				String str = null;
				while((str=bf.readLine())!=null){
					if(str.matches("\\s*")){
						blankNum++;//空白行
					}else if(str.contains("/*") || str.contains("//")){
						noteNum++;//注释行
					}else {
						lineNum++;//代码行
					}
				}			
			
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\Eclipse工作空间\\eclipse\\work");
		if(file.isDirectory()){
			getFiles(file);
		}else{
			if(file.isFile() && file.getName().endsWith(".java")){
				isJava(file);
			}
		}
		
		System.out.println("代码行数："+lineNum+"注释行数:"+noteNum+"空行："+blankNum);
	
	}
}



 
 