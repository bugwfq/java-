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
	 * 3.����D:/dirĿ¼�·���10���ļ�,�ļ���Ϊ:file001.txt,file002,file003.txt......file10.txt��
	 * ��дһ��Ч���򣬽���10���ļ������ݰ��ļ������˳��ϲ���һ���ļ�file.txt�� �����һ��˼·�ǣ�  
	 * a������PrintWriter����file.txt׼��д�� 
	 * b����bufferedReader���δ�ÿ���ļ���Ȼ��ÿ��һ�У���д��һ�С�
	 * ���ﲻ��ÿ���ļ����� �����ڴ���Ȼ��һ��д���Ŀ���Ƿ�ֹ�ļ����ݹ��� 
	 * ����(File,PrintWriter,BufferedReader)
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