package IOStream.day170601.work;

import java.io.File;
import java.util.LinkedList;

import org.junit.Test;

public class AllMyFiles {
	private int folderNum = 0;//文件夹个数
	private int fileNum = 0;//文件个数
	
	private void fileIter(File file){
		File[] fs = file.listFiles();//获取该目录下所有文件和文件夹
		//遍历数组
		if(fs!=null){
			for (File temp : fs) {
				if(temp.isDirectory()){//目录需要继续遍历
					folderNum++;
					System.out.println(temp.getPath());
					fileIter(temp);//递归公式
				}else{//递归出口:当File对象是个文件时
					fileNum++;
					System.out.println(temp.getPath());
				}
			}
		}
		
	}
	
	
	private void fileIter2(File file){
		File[] fs = file.listFiles();//获取该路径下的所有文件夹或文件
		
		//创建一个集合存储文件夹对象
		LinkedList<File> list = new LinkedList<>();
		
		//遍历数组
		for (File temp : fs) {
			if(temp.isDirectory()){//目录
				list.add(temp);//将目录加入集合	
			}else{
				fileNum++;
				System.out.println(temp.getPath());
			}
		}
		
		//遍历集合
		while(list.size()>0){
			File tempFile = list.poll();//获取并删除这个文件夹
			
			System.out.println(tempFile.getPath());//将这个文件夹打印
			folderNum++;
			
			//获取这个文件夹下的所有文件夹和文件
			File[] tempFs = tempFile.listFiles();
			//遍历数组
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
			System.out.println("文件夹个数："+folderNum+"文件个数："+fileNum);
		}else{
			System.out.println("这不是个目录，文件夹个数：0，文件个数：1");
		}
	}
	
	@Test
	public void test2(){
		File file = new File("E:\\javacode");
		if(file.isDirectory()){
			fileIter2(file);
			System.out.println("文件夹个数："+folderNum+"文件个数："+fileNum);
		}else{
			System.out.println("这不是个目录，文件夹个数：0，文件个数：1");
		}
	}
}
