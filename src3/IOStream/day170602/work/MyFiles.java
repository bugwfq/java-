package IOStream.day170602.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;
/**
 * �ֱ�ͳ�ƴ���������ע��������������
 * @author Administrator
 
 */
public class MyFiles {
	private static int lineNum = 0;//��������
	private static int noteNum = 0;//ע������
	private static int blankNum = 0;//������
	
	private static void getFiles(File file){
		File[] fs = file.listFiles();//��ȡָ��·���µ������ļ����ļ���
		if(fs==null){
			return;
		}
		//��������
		for (File temp : fs) {//�ݹ���ڣ���File�������ļ�
			if(temp.isFile() && temp.getName().endsWith(".java")){
				isJava(temp);
			}else{
				getFiles(temp);
			}
		}
		
	}

	private static void isJava(File temp) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(temp));
			try {
				String str = null;
				while((str=bf.readLine())!=null){
					if(str.matches("\\s*")){
						blankNum++;//�հ���
					}else if(str.contains("/*") || str.contains("//")){
						noteNum++;//ע����
					}else {
						lineNum++;//������
					}
				}			
			
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\Eclipse�����ռ�\\eclipse\\work");
		if(file.isDirectory()){
			getFiles(file);
		}else{
			if(file.isFile() && file.getName().endsWith(".java")){
				isJava(file);
			}
		}
		
		System.out.println("����������"+lineNum+"ע������:"+noteNum+"���У�"+blankNum);
	
	}
}



 
 