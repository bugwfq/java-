package IOStream.day170610;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class Hw2 {
	/**
	 * 2.在控制台输入一串字符串，然后将其分类，并完成字母大小写之间的转换。通过File
	 * 对象创建不同类型的文件，然后将其内容保存至不同的文件. 
	 * @throws IOException 
	 */
	@Test
	public void test() throws IOException{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		StringBuilder digit = new StringBuilder();
		StringBuilder lower = new StringBuilder();
		StringBuilder upper = new StringBuilder();
		StringBuilder java = new StringBuilder();
		StringBuilder others = new StringBuilder();
		
		//将字符串转化为数组
		char[] cs = str.toCharArray();
		//遍历数组
		for (char c : cs) {
			if(Character.isDigit(c)){
				digit.append(c);//数字
			}else if(Character.isLowerCase(c)){
				lower.append(Character.toUpperCase(c));//小写转大写
			}else if(Character.isUpperCase(c)){
				upper.append(Character.toLowerCase(c));//大写转小写
			}else if(Character.isJavaIdentifierStart(c)){
				java.append(c);//java标示符
			}else{//非法字符
				others.append(c);				
			}
		}
		
		//将内容存入对应的文件
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2digit.txt")));
		bw.append(digit);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2lower.txt")));
		bw.append(lower);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2upper.txt")));
		bw.append(upper);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2java.txt")));
		bw.append(java);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2others.txt")));
		bw.append(others);
		bw.flush();
		
		bw.close();
	}
}
