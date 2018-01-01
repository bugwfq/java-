package IOStream.day170610;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Hw1 {
	/**
	 * 1.使用FileInputStream和FileOutputStream将两个文件的内容合并至一个新的文件，新的文件将包含这两个文件的内容.
	 * @throws IOException 
	 */
	@Test
	public void test() throws IOException{
		FileInputStream fs = new FileInputStream(new File("src3/day170610/hw1a.txt"));//文件输入流与文件连接（将文件内容读取输入到程序中）
		FileOutputStream fos = new FileOutputStream(new File("src3/day170610/hw1c.txt"),true);//文件输出流与文件连接（将程序中的内容输出并写入到文件中）
		
		int mark = 0;
		while((mark=fs.read())!=-1){
			fos.write(mark);//将从文件中读到的内容写入新文件中
		}
		
		fs = new FileInputStream(new File("src3/day170610/hw1b.txt"));//文件输入流与文件连接（将文件内容读取并输入到程序）
		mark = 0;
		while((mark=fs.read())!=-1){
			fos.write(mark);//将文件内容追加到后面
		}
		
		fs.close();
		fos.close();
		
	}
}
