package IOStream.day170610;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Hw1 {
	/**
	 * 1.ʹ��FileInputStream��FileOutputStream�������ļ������ݺϲ���һ���µ��ļ����µ��ļ��������������ļ�������.
	 * @throws IOException 
	 */
	@Test
	public void test() throws IOException{
		FileInputStream fs = new FileInputStream(new File("src3/day170610/hw1a.txt"));//�ļ����������ļ����ӣ����ļ����ݶ�ȡ���뵽�����У�
		FileOutputStream fos = new FileOutputStream(new File("src3/day170610/hw1c.txt"),true);//�ļ���������ļ����ӣ��������е����������д�뵽�ļ��У�
		
		int mark = 0;
		while((mark=fs.read())!=-1){
			fos.write(mark);//�����ļ��ж���������д�����ļ���
		}
		
		fs = new FileInputStream(new File("src3/day170610/hw1b.txt"));//�ļ����������ļ����ӣ����ļ����ݶ�ȡ�����뵽����
		mark = 0;
		while((mark=fs.read())!=-1){
			fos.write(mark);//���ļ�����׷�ӵ�����
		}
		
		fs.close();
		fos.close();
		
	}
}
