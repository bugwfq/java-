package collection.day170516.regex;

public class RegexTest2 {
	public static void main(String[] args) {
		String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		String str1 = "aaa@";
		String str2 = "aaaaa";
		String str3 = "18919890415@sina.cn";
		
		if(str1.matches(regex)){
			System.out.println(str1+"��һ���Ϸ��������ַ");
		}
		if(str2.matches(regex)){
			System.out.println(str2+"��һ���Ϸ��������ַ");
		}
		if(str3.matches(regex)){
			System.out.println(str3+"��һ���Ϸ��������ַ");
		}
	}
}
