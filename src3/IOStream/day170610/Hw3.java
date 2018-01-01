package IOStream.day170610;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;

import org.junit.Test;

public class Hw3 {
	/**
	 * 3.假设D:/dir目录下放着10个文件,文件名为:file001.txt,file002,file003.txt......file10.txt。
	 * 请写一高效程序，将这10个文件的内容按文件名编号顺序合并成一个文件file.txt。 这题的一般思路是：  
	 * a、利用PrintWriter创建file.txt准备写入 
	 * b、用bufferedReader依次打开每个文件，然后每读一行，就写入一行。
	 * 这里不把每个文件内容 存在内存里然后一并写入的目的是防止文件内容过大。 
	 * 考点(File,PrintWriter,BufferedReader)
	 * @throws IOException 
	 */
	@Test
	public void test()throws Exception{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170610/dir/file.txt")));
		BufferedReader br = null;
		for(int i=1;i<=10;i++){
			String path = "src3/day170610/dir/file00"+i+".txt";
			File file = new File(path);
			br = new BufferedReader(new FileReader(file));
			String str = null;
			while((str=br.readLine())!=null){
				pw.println(str);
				pw.flush();
			}
		}
		
		br.close();
		pw.close();
	}
}