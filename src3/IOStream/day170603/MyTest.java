package IOStream.day170603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class MyTest {
	private static final int BUFFER_SIZE = 1024;

	//@Test
	public void test1() throws IOException, InterruptedException{
		/**
		 * ��һ���ļ����Ƶ���һ���ط�
		 * 1.��ȡԴ�ļ�
		 * 2.��������ԭ�ļ�д��Ŀ�ĵ�
		 * 3.�����ı��ļ����ַ���
		 * 4.�ر�����Դ
		 */
		FileReader fr = new FileReader("src3/day170603/MyTest.java");//�Դ�ļ������Ĺܵ����������
		FileWriter fw = new FileWriter("src3/day170603/mt.txt");//�������Ŀ�ĵ��ļ��Ĺܵ���д���ļ���
		int mark = 0;
		while((mark=fr.read())!=-1){
			fw.write(mark);		//��һ���ַ�дһ���ַ�	
		}
		
		//�ر�����Դ
		fr.close();
		fw.close();
	}
	
	//@Test
	public void test2(){
		/**
		 * ���������
		 */
		
		FileReader fr = null;
		FileWriter fw = null;
	
		try {
			fr = new FileReader("src3/day170603/MyTest.java");
			fw = new FileWriter("src3/day170603/mt.txt");
			char[] cs = new char[BUFFER_SIZE];
			int mark = 0;
			while((mark=fr.read(cs))!=-1){
				fw.write(cs, 0, mark);//�߶���д��0����ʼ��λ�ã�Mark���������ַ�����
			}
		} catch (Exception e) {
			throw new RuntimeException("��дʧ��");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	public void test3() throws IOException{
		
		FileReader fr = new FileReader("src3/day170603/MyTest.java");
		BufferedReader br = new BufferedReader(fr);//���������ļ�������
		
		FileWriter fw = new FileWriter("src3/day170603/b.txt");
		BufferedWriter bw = new BufferedWriter(fw);//���������ļ�������
		
		String line = null;
		while((line = br.readLine())!=null){//�߶���д
			bw.write(line);
			bw.newLine();//ÿдһ�Σ�����һ��
			bw.flush();//ˢ��һ��
		}
			
		fr.close();
		fw.close();
		
		
	}
}
