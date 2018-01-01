package IOStream.day170608;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ForTest文件个数 {
	private static int fileNum = 0;
	private static int folderNum = 0;
	private static LinkedList<File> list = new LinkedList<>();
	private static StringBuilder fileName = new StringBuilder();
	private static StringBuilder folderName = new StringBuilder();
	
	private static void getFiles(File file){
		File[] fs = file.listFiles();
		if(fs==null){
			return;
		}
		
		for (File temp : fs) {
			if(temp.isFile()){
				fileNum++;
				fileName.append(temp+"\n");
			}else{
				folderNum++;
				list.add(temp);
				folderName.append(temp+"\n");
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("src3/day170606");
		getFiles(file);
		while(list.size()>0){
			File temp = list.poll();
			getFiles(temp);
		}
		
		System.out.println("文件个数："+fileNum+"文件夹个数："+folderNum);
		
		BufferedWriter fileBw = new BufferedWriter(new FileWriter(new File("src3/day170608/files.txt")));
		BufferedWriter folderBw = new BufferedWriter(new FileWriter(new File("src3/day170608/folders.txt")));
		fileBw.append(fileName);
		fileBw.close();
		
		folderBw.append(folderName);
		folderBw.close();
	}
}
