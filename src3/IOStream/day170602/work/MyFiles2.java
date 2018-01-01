package IOStream.day170602.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class MyFiles2 {
	private static int codeNum = 0;//��������
	private static int noteNum = 0;//ע������
	private static int blankNum = 0;//�հ�����
	
	
	/**
	 * ����ָ��·����ȡ����.java�ļ�
	 * @param file
	 */
	public static void getFiles(File file){
		File[] fs = file.listFiles();//��ȡ��Ŀ¼�������ļ����ļ���
		if(fs==null){
			return;
		}
		//��������
		for (File temp : fs) {
			if(temp.isFile() && temp.getName().endsWith(".java")){
				isJava(temp);
			}else{
				getFiles(temp);
			}
		}
	}

	
	/**
	 * ͳ��java�ļ���Ĵ���������ע���������հ�����
	 * @param temp
	 */
	private static void isJava(File temp) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(temp));
			String str = null;
			try {
				while((str=br.readLine())!=null){
					if(str.matches("\\s*")){//�հ���
						blankNum++;
					}else if(str.contains("/*") || str.contains("//")){//ע����
						noteNum++;
					}else{//������
						codeNum++;
					}
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\Eclipse�����ռ�\\eclipse\\work");
		if(file.isDirectory()){//Ŀ¼
			getFiles(file);
		}else{//�ļ�
			if(file.isFile() && file.getName().endsWith(".java")){
				isJava(file);
			}
		}
		
		System.out.println("����������"+codeNum+"ע������:"+noteNum+"���У�"+blankNum);
	}
}
