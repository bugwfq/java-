package day170329String类.work;
import org.junit.Test;
public class Test1 {
	
	@Test
	public void test1(){	
		MyString m = new MyString("abcdefb");
		System.out.println(m.codePointAt(3));// 返回指定索引处的字符（Unicode 代码点)
		System.out.println(m.codePointBefore(3));// 返回指定索引之前的字符（Unicode 代码点）
		System.out.println(m.compareTo("delg"));// 按字典顺序比较两个字符串
		System.out.println(m.compareToIgnoreCase("AgjdAd"));//-5 按字典顺序比较两个字符串，不考虑大小写
		System.out.println(m.concat("ghijkl"));// 将指定字符串连接到此字符串的结尾
		char[] data = {'h','a','p','p','y'};
		System.out.println(MyString.copyValueOf(data));//happy 返回指定数组中表示该字符序列的 String
		System.out.println(MyString.copyValueOf(data, 1, 3));//app 返回指定数组中表示该字符序列的 String	
		System.out.println(m.endsWith("efb"));// 测试此字符串是否以指定的后缀结束
		System.out.println(m.indexOf(98));//返回指定字符在此字符串中第一次出现处的索引
		System.out.println(m.indexOf(98, 2));//返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
		System.out.println(m.indexOf("cd"));//返回指定子字符串在此字符串中第一次出现处的索引
		System.out.println(m.indexOf("de", 2));//返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
		System.out.println(m.equals("abcdefb"));//将此字符串与指定的对象比较
		System.out.println(m.equalsIgnoreCase("abCdefB"));//将此 String 与另一个 String 比较，不考虑大小写。
		MyString n = new MyString("");	
		System.out.println(n.isEmpty());//当且仅当 length() 为 0 时返回 true。
		System.out.println(m.lastIndexOf(98));//返回指定字符在此字符串中最后一次出现处的索引
		MyString x = new MyString("abcabcabc");
		System.out.println(x.lastIndexOf(97,5));
		
		char[] dst =new char[m.length()];
		m.getChars(1, 4,dst , 1);
		for(char i:dst){
			System.out.println(i);//  将字符从此字符串复制到目标字符数组
		}
		
		MyString y = new MyString("  hello world   ");	
		System.out.println(y.trim());//返回字符串的副本，忽略前导空白和尾部空白
		
		System.out.println(m.replaceFirst("ab", "jjj"));//使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串

		String s = "abcabcabcidabeiabe";
		MyString ms = new MyString(s);
		System.out.println(ms.replaceAll("abc", "abd"));//用新字符串替换旧字符串	
		System.out.println(ms.substring(8));//返回一个新的字符串，它是此字符串的一个子字符串
		System.out.println(ms.substring(3, 9));//返回一个新字符串，它是此字符串的一个子字符串
	}
	
}
