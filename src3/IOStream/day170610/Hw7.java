package IOStream.day170610;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class Hw7 {
	/**
	 * 7.统计某个目录底下java文件里的java代码行数
	 */
	
	private int emptyNum = 0;//空白行
	private int noteNum = 0;//注释行
	private int codeNum = 0;//代码行
	private int fileNum = 0;//文件数
	private int folderNum = 0;//文件夹数
	
	StringBuilder fileName = new StringBuilder();
	StringBuilder folderName = new StringBuilder();
	private void getFile(File file){
		File[] fs = file.listFiles();
		if(fs == null){
			return;
		}
		
		//遍历数组
		for (File temp : fs) {
			if(temp.isDirectory()){
				getFile(temp);
				folderNum++;
				folderName.append(temp+"\n");
			}else{
				if(temp.isFile() && temp.getName().endsWith(".java")){
					isJava(temp);//统计代码
				}
				fileNum++;
				fileName.append(temp+"\n");
			}
		}
	}

	private void isJava(File temp) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(temp));
			String str = null;
			try {
				while((str=br.readLine())!=null){
					String tempS = str.trim();//去掉首尾空白
					if(tempS.equals("")){
						emptyNum++;
					}else if(tempS.startsWith("//")){
						noteNum++;
					}else if(tempS.startsWith("/*")){
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() throws IOException{
		File file = new File("src3/day170606");
		getFile(file);
		
		System.out.println("空白行："+emptyNum+"注释行："+noteNum+"代码行："+codeNum);
		System.out.println("文件数："+folderNum+"文件夹数："+fileNum);
		
		//将文件和文件夹分别存入文件中
		BufferedWriter fileBw = new BufferedWriter(new FileWriter("src3/day170610/file.txt"));
		fileBw.append(fileName);
		fileBw.close();
		
		BufferedWriter folderBw = new BufferedWriter(new FileWriter("src3/day170610/folder.txt"));
		folderBw.append(folderName);
		folderBw.close();
	}
	
}
