package IOStream.day170531.work;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class AllMyFiles_For {
	private static LinkedList<File> list = new LinkedList<>();//�洢·��
	private static int folderNum = 0;//��¼�ļ��еĸ���
	private static int fileNum = 0;//��¼�ļ�����
	
	public static void getFile(File file){
		File[] fs = file.listFiles();//��File�����������ļ���·������������
		
		if(fs==null){
			return;
		}
		
		//��������
		for (File temp : fs) {
			if(temp.isDirectory()){
				list.add(temp);//���ļ��д��뼯��
				folderNum++;
			}else{
				fileNum++;
			}
			System.out.println(temp);
		}
		
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\javacode");
		getFile(file);
//		int index = 0;
		//��������
		while(0<list.size()){
//			File temp = list.get(index);
			File temp = list.poll();
			getFile(temp);		
//			index++;
		}
		System.out.println("�ļ��и���:"+folderNum+"�ļ�������"+fileNum);
	}
}
