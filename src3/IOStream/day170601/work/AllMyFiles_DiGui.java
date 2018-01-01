package IOStream.day170601.work;

import java.io.File;

public class AllMyFiles_DiGui {
	private static int folderNum = 0;
	private static int fileNum = 0;
	
	public static void getFile(File file){
		//��File������������ļ���·������������
		File[] fs = file.listFiles();
		
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
		}
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\javacode");
		getFile(file);
		System.out.println("�ļ��и�����"+folderNum+"�ļ�������"+fileNum);
	}
}
