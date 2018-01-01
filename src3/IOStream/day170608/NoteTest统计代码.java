package IOStream.day170608;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class NoteTestͳ�ƴ��� {

	
	private int codeNum = 0;//��������
	private int noteNum = 0;//ע������
	private int emptyNum = 0;//�հ�����
	
	private void getFiles(File file){
		File[] fs = file.listFiles();
		if(fs==null){
			return;
		}
		//��������
		for (File temp : fs) {
			if(temp.isDirectory()){
				getFiles(temp);
			}else{
				if(temp.isFile() && temp.getName().endsWith(".java")){
					isJavaFile(temp);//ͳ�ƴ���
				}
			}
		}
	}
	
	private void isJavaFile(File temp) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(temp));
			String str = null;
			try {
				while((str = br.readLine())!=null){
					String tempStr = str.trim();//ȥ����β�հ�
					if(tempStr.equals("")){
						emptyNum++;
					}else if(tempStr.startsWith("//")){
						noteNum++;
					}else if(tempStr.startsWith("/*")){
						noteNum++;
						String s = null;
						while((s=br.readLine())!=null){
							noteNum++;
							if(s.endsWith("*/")){
								break;
							}		
						}
						noteNum++;
					}else{
						codeNum++;
					}
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");			
		}
		
	}

	@Test
	public void test(){
		/**
		 * ͳ�ƴ���
		 */
		File file = new File("src3/day170608/NoteTest.java");
		if(file.isDirectory()){
			getFiles(file);
		}else{
			if(file.getName().endsWith(".java")){
				isJavaFile(file);
			}
		}

		System.out.println("�����У�"+codeNum+"ע���У�"+noteNum+"�հ��У�"+emptyNum);
		
	}
}
