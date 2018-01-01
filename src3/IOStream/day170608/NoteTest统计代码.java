package IOStream.day170608;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class NoteTest统计代码 {

	
	private int codeNum = 0;//代码行数
	private int noteNum = 0;//注释行数
	private int emptyNum = 0;//空白行数
	
	private void getFiles(File file){
		File[] fs = file.listFiles();
		if(fs==null){
			return;
		}
		//遍历数组
		for (File temp : fs) {
			if(temp.isDirectory()){
				getFiles(temp);
			}else{
				if(temp.isFile() && temp.getName().endsWith(".java")){
					isJavaFile(temp);//统计代码
				}
			}
		}
	}
	
	private void isJavaFile(File temp) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(temp));
			String str = null;
			try {
				while((str = br.readLine())!=null){
					String tempStr = str.trim();//去掉首尾空白
					if(tempStr.equals("")){
						emptyNum++;
					}else if(tempStr.startsWith("//")){
						noteNum++;
					}else if(tempStr.startsWith("/*")){
						noteNum++;
						String s = null;
						while((s=br.readLine())!=null){
							noteNum++;
							if(s.endsWith("*/")){
								break;
							}		
						}
						noteNum++;
					}else{
						codeNum++;
					}
				}
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");			
		}
		
	}

	@Test
	public void test(){
		/**
		 * 统计代码
		 */
		File file = new File("src3/day170608/NoteTest.java");
		if(file.isDirectory()){
			getFiles(file);
		}else{
			if(file.getName().endsWith(".java")){
				isJavaFile(file);
			}
		}

		System.out.println("代码行："+codeNum+"注释行："+noteNum+"空白行："+emptyNum);
		
	}
}
