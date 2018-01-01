package IOStream.day170610.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		//将字符串转化成数组
		char[] cs = str.toCharArray();
		//遍历数组
		for (char c : cs) {
			if(Character.isDigit(c)){//数字
				digit.append(c);
			}else if(Character.isLowerCase(c)){//小写字母
				lower.append(Character.toUpperCase(c));//小写字母转成大写
			}else if(Character.isUpperCase(c)){//大写字母
				upper.append(Character.toLowerCase(c));//大写字母转成小写
			}else if(Character.isJavaIdentifierPart(c)){
				java.append(c);
			}else{
				others.append(c);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/digit.txt")));
		bw.append(digit);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/lower.txt")));
		bw.append(lower);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/upper.txt")));
		bw.append(upper);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/java.txt")));
		bw.append(java);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/others.txt")));
		bw.append(others);
		bw.close();
	}
}
