package exception.day170525;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MyRegexTest {
	//@Test
	public void test1(){
		//匹配6个数字
		String str = "dkng2857948khdk95935jgka993885k854ja8939339jkdf85038mk853900";
		/**
		 * 285794
		 * 993885
		 * 893933
		 * 853900
		 */
		
		String regex = "\\d{6}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}		
	}
	
	//@Test
	public void test2(){
		//split
		String str = "algndklsj";
		String regex = ",";
		Pattern p = Pattern.compile(regex);//编译正则表达式
		String[] s = p.split(str);//用指定正则表达式拆分字符串
		for (String temp : s) {
			System.out.println(temp);
		}
	}
	
	//@Test
	public void test3(){
		// 查找字符串里面4-6位数字子串
		/**
		 * 34348
		 * 9935 
		 * 693395
		 * 934358
		 * 84583
		 */
		String str = "jtri34348j9l9935dejse994j8oj693395858dilrjao934358jf84583kkd";
		String regex = "\\d{4,6}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	//@Test
	public void test4(){
		// 用于保存账号信息(账号由4-6位字母组成的用户名，密码由4-6位数字组成)，admin1234
		String str = "admin123456kdjl3325lnk890ljdf3283ikdf5933922kfji00538lm095898djfij589simon85985";
		String regex = "[a-zA-Z]{4,6}\\d{4,6}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	//@Test
	public void test5(){
		// 请将这个字符串包含合法账号提取出来
		String str = "admin123456kdjl3325lnk890ljdf3283ikdf5933922kfji00538lm095898djfij589simon85985";
		String regex = "([a-zA-Z]{4,6})(\\d{4,6})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while(m.find()){
//			System.out.println(m.group(1));	
			System.out.println(m.group(2));
		}
		
		m.find(1);//1是从指定索引开始
		System.out.println(m.group());
	}
	
	//@Test
	public void test6(){
		String s = "abc jAva JAva JAVA java JAVa jAVA JaVA sdfjl";
		String regex = "java";
		Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		while(m.find()){
			count++;
			if(count%2==0){//偶数
				m.appendReplacement(buffer,"JAVA");
			}else{//奇数
				m.appendReplacement(buffer, "java");
			}
		}
		
		m.appendTail(buffer);
		System.out.println(buffer);
	}
	

	//@Test
	public void test7(){
		//比较String和Matcher中的replaceFirst方法和replaceAll方法
		/*String s = "helle aa,helle bb,helle cc";
//		String newS = s.replaceFirst("helle", "hello");
		String newS = s.replaceAll("helle", "hello");
		System.out.println(newS);*/
		
		String s = "helle aa,helle bb,helle cc";
		String regex = "helle";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
//		String newS = m.replaceFirst("hello");
		String newS = m.replaceAll("hello");
		System.out.println(newS);
		
	}
	

	//@Test
	public void test8(){
		// ok20
		
		String str = "kdfiok300jaojk0j85ko8573dpook200jaok";
		String regex = "ok(\\d{1,3})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		double pay = 0;
		while(m.find()){
			pay += Double.valueOf(m.group(1));
		}
		System.out.println(pay);
		
	}
	

	@Test
	public void test9(){
		String str = "odk20kd80kdjf335dij";
		String regex = "[a-z]{2}\\d{2}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		/*while(m.find()){
			
//			System.out.println(m.group());
//			m.reset(str);//会死循环
			System.out.println(m.start()+"----"+m.end());
		}*/
		m.find();
		m.reset();
		m.find();
		System.out.println(m.group());
	}
}
