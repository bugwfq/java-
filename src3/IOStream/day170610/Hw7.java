package IOStream.day170610;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class Hw7 {
	/**
	 * 7.ͳ��ĳ��Ŀ¼����java�ļ����java��������
	 */
	
	private int emptyNum = 0;//�հ���
	private int noteNum = 0;//ע����
	private int codeNum = 0;//������
	private int fileNum = 0;//�ļ���
	private int folderNum = 0;//�ļ�����
	
	StringBuilder fileName = new StringBuilder();
	StringBuilder folderName = new StringBuilder();
	private void getFile(File file){
		File[] fs = file.listFiles();
		if(fs == null){
			return;
		}
		
		//��������
		for (File temp : fs) {
			if(temp.isDirectory()){
				getFile(temp);
				folderNum++;
				folderName.append(temp+"\n");
			}else{
				if(temp.isFile() && temp.getName().endsWith(".java")){
					isJava(temp);//ͳ�ƴ���
				}
				fileNum++;
				fileName.append(temp+"\n");
			}
		}
	}

	private void isJava(File temp) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(temp));
			String str = null;
			try {
				while((str=br.readLine())!=null){
					String tempS = str.trim();//ȥ����β�հ�
					if(tempS.equals("")){
						emptyNum++;
					}else if(tempS.startsWith("//")){
						noteNum++;
					}else if(tempS.startsWith("/*")){
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() throws IOException{
		File file = new File("src3/day170606");
		getFile(file);
		
		System.out.println("�հ��У�"+emptyNum+"ע���У�"+noteNum+"�����У�"+codeNum);
		System.out.println("�ļ�����"+folderNum+"�ļ�������"+fileNum);
		
		//���ļ����ļ��зֱ�����ļ���
		BufferedWriter fileBw = new BufferedWriter(new FileWriter("src3/day170610/file.txt"));
		fileBw.append(fileName);
		fileBw.close();
		
		BufferedWriter folderBw = new BufferedWriter(new FileWriter("src3/day170610/folder.txt"));
		folderBw.append(folderName);
		folderBw.close();
	}
	
}
