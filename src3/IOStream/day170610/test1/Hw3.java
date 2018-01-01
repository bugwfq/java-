package IOStream.day170610.test1;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * 3.����D:/dirĿ¼�·���10���ļ�,�ļ���Ϊ:file001.txt,file002,file003.txt......file10.txt��
 * ��дһ��Ч���򣬽���10���ļ������ݰ��ļ������˳��ϲ���һ���ļ�file.txt�� �����һ��˼·�ǣ�  
 * a������PrintWriter����file.txt׼��д�� 
 * b����bufferedReader���δ�ÿ���ļ���Ȼ��ÿ��һ�У���д��һ�С�
 * ���ﲻ��ÿ���ļ����� �����ڴ���Ȼ��һ��д���Ŀ���Ƿ�ֹ�ļ����ݹ��� 
 * ����(File,PrintWriter,BufferedReader)
 * @throws IOException 
 */
public class Hw3 {
	@Test
	public void test()throws Exception{
		PrintWriter pw = new PrintWriter(new File("src3/day170610/test1/hw3/file.txt"));
		BufferedReader br = null;
		for(int i=1;i<=10;i++){
			String path = "src3/day170610/test1/hw3/file00"+i+".txt";
			File file = new File(path);
			br = new BufferedReader(new FileReader(file));
			String str = null;
			while((str=br.readLine())!=null){
				pw.println(str);
				pw.flush();
			}
		}
		
		pw.close();
		br.close();
		
	}
}
