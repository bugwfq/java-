package IOStream.day170601.work;

import java.io.File;
import java.util.LinkedList;

import org.junit.Test;

public class AllMyFiles {
	private int folderNum = 0;//�ļ��и���
	private int fileNum = 0;//�ļ�����
	
	private void fileIter(File file){
		File[] fs = file.listFiles();//��ȡ��Ŀ¼�������ļ����ļ���
		//��������
		if(fs!=null){
			for (File temp : fs) {
				if(temp.isDirectory()){//Ŀ¼��Ҫ��������
					folderNum++;
					System.out.println(temp.getPath());
					fileIter(temp);//�ݹ鹫ʽ
				}else{//�ݹ����:��File�����Ǹ��ļ�ʱ
					fileNum++;
					System.out.println(temp.getPath());
				}
			}
		}
		
	}
	
	
	private void fileIter2(File file){
		File[] fs = file.listFiles();//��ȡ��·���µ������ļ��л��ļ�
		
		//����һ�����ϴ洢�ļ��ж���
		LinkedList<File> list = new LinkedList<>();
		
		//��������
		for (File temp : fs) {
			if(temp.isDirectory()){//Ŀ¼
				list.add(temp);//��Ŀ¼���뼯��	
			}else{
				fileNum++;
				System.out.println(temp.getPath());
			}
		}
		
		//��������
		while(list.size()>0){
			File tempFile = list.poll();//��ȡ��ɾ������ļ���
			
			System.out.println(tempFile.getPath());//������ļ��д�ӡ
			folderNum++;
			
			//��ȡ����ļ����µ������ļ��к��ļ�
			File[] tempFs = tempFile.listFiles();
			//��������
			for(File temp:tempFs){
				if(temp.isDirectory()){
					list.add(temp);
				}else{
					fileNum++;
					System.out.println(temp.getPath());
				}
			}
		}
	}
	//@Test
	public void test1(){
		File file = new File("E:\\javacode");
		if(file.isDirectory()){
			fileIter(file);
			System.out.println("�ļ��и�����"+folderNum+"�ļ�������"+fileNum);
		}else{
			System.out.println("�ⲻ�Ǹ�Ŀ¼���ļ��и�����0���ļ�������1");
		}
	}
	
	@Test
	public void test2(){
		File file = new File("E:\\javacode");
		if(file.isDirectory()){
			fileIter2(file);
			System.out.println("�ļ��и�����"+folderNum+"�ļ�������"+fileNum);
		}else{
			System.out.println("�ⲻ�Ǹ�Ŀ¼���ļ��и�����0���ļ�������1");
		}
	}
}
