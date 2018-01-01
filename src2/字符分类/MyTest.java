package 字符分类;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		/**
		 * 4.分析字符串程序。在控制台任水电费意输出一串字符，将字母、数字、其它字符区分开打印到控制台。
		 * 比如输入”abcDEF123!@#”,那么程序运行结果为：
		 * 字母:abcDEF
		 * 数字:123
		 *其它字符:!@#
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一串字符");
		String s = sc.next();
		//字母
		char[] c = s.toCharArray();
		System.out.println("字母：");
		for(int i=0;i<s.length();i++){
			if(Character.isLetter(c[i])){
				System.out.print(c[i]+"");
			}
		}
		//数字
		System.out.println();
		System.out.println("数字:");
		for(int i=0;i<s.length();i++){
			if(Character.isDigit(c[i])){
				System.out.print(c[i]+"");
			}
		}
		//其他字符
		System.out.println();
		System.out.println("其他字符:");
		for(int i=0;i<s.length();i++){
			if(Character.isLetterOrDigit(c[i])==false && Character.isJavaIdentifierStart(c[i])==false){
				System.out.print(c[i]+"");
			}
		}
	}
}
