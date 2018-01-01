package IOStream.day170608;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
/**
 * 
 * @param args
 * @throws Exception
 */ /*32423234*/

/**
 * 
 * @param args
 * @throws Exception
 */ // 123123

/**
 * 
 * @param args
 * @throws Exception
 */ /*sdfsdf*//*sdfsdf*/


/**
 * 
 * @param args
 * @throws Exception
 */  /*
 *
 *
 *
 *
 *
 **/
public class DiGuiTest文件个数 {
	private int fileNum = 0;
	private int folderNum = 0;
	StringBuilder fileName = new StringBuilder();
	StringBuilder folderName = new StringBuilder();
	private void getFiles(File file){
		File[] fs = file.listFiles();
		for (File temp : fs) {
			if(temp.isDirectory()){
				getFiles(temp);
				folderNum++;
				folderName.append(temp+"\n");
			}else{
				fileNum++;
				fileName.append(temp+"\n");
			}
		}
		
	}
	
	@Test
	public void test() throws IOException{
		File file = new File("src3/day170606");
		getFiles(file);
		System.out.println("文件个数："+fileNum+"文件夹个数："+folderNum);
		BufferedWriter fileBw = new BufferedWriter(new FileWriter(new File("src3/day170608/file.txt")));
		BufferedWriter folderBw = new BufferedWriter(new FileWriter(new File("src3/day170608/folder.txt")));
		fileBw.append(fileName);
		fileBw.close();
		folderBw.append(folderName);
		folderBw.close();
	}
}
