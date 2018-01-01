package IOStream.day170601.test;

import java.io.File;

public class MyFileTest {
	/**
	 * �õݹ�ͳ��ָ��Ŀ¼�µ������ļ����ļ���
	 */
	private static int folderNum = 0;
	private static int fileNum = 0;
	
	public static void getFile(File file){
		File[] fs = file.listFiles();//��file·���µ��������ļ���·����������
		
		if(fs==null){
			return;
		}
		//��������
		for (File temp : fs) {
			if(temp.isFile()){
				System.out.println(temp);
				fileNum++;
			}else{
				getFile(temp);
				folderNum++;
			}
			System.out.println(temp);
		} 
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\");
		getFile(file);
		System.out.println("�ļ���������"+folderNum+"�ļ�������"+fileNum);
	}
}
