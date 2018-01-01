package IOStream.day170601.test;

import java.io.File;

public class MyFileTest {
	/**
	 * 用递归统计指定目录下的所有文件和文件夹
	 */
	private static int folderNum = 0;
	private static int fileNum = 0;
	
	public static void getFile(File file){
		File[] fs = file.listFiles();//将file路径下的所有子文件或路径存入数组
		
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
			System.out.println(temp);
		} 
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\");
		getFile(file);
		System.out.println("文件夹总数："+folderNum+"文件总数："+fileNum);
	}
}
