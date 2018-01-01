package IOStream.day170601.work;

import java.io.File;

public class AllMyFiles_DiGui {
	private static int folderNum = 0;
	private static int fileNum = 0;
	
	public static void getFile(File file){
		//将File对象的所有子文件或路径存入数组中
		File[] fs = file.listFiles();
		
		if(fs==null){
			return;
		}
		//遍历数组
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
		System.out.println("文件夹个数："+folderNum+"文件个数："+fileNum);
	}
}
