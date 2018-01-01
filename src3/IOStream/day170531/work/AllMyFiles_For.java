package IOStream.day170531.work;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class AllMyFiles_For {
	private static LinkedList<File> list = new LinkedList<>();//存储路径
	private static int folderNum = 0;//记录文件夹的个数
	private static int fileNum = 0;//记录文件个数
	
	public static void getFile(File file){
		File[] fs = file.listFiles();//将File对象所有子文件和路径存入数组中
		
		if(fs==null){
			return;
		}
		
		//遍历数组
		for (File temp : fs) {
			if(temp.isDirectory()){
				list.add(temp);//将文件夹存入集合
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
		//遍历集合
		while(0<list.size()){
//			File temp = list.get(index);
			File temp = list.poll();
			getFile(temp);		
//			index++;
		}
		System.out.println("文件夹个数:"+folderNum+"文件个数："+fileNum);
	}
}
