package exception.day170525;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MyRegex {
	//@Test
	public void test1(){
		//ƥ��5����ĸ
		String regex = "[a-zA-z]{5}";
		boolean bool = Pattern.matches(regex, "abcjg");
		System.out.println(bool);
	}
	
	//@Test
	public void test2(){
		//ƥ��6����ĸ���Դ�Сд
		String regex = "[a-zA-Z]{6}";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("dGhOir");
		boolean bool = m.matches();
		System.out.println(bool);
	}
	
	//@Test
	public void test3(){
		String regex = ",";
		Pattern p = Pattern.compile(regex);
		String str = "a,b,c,d,e";		
		String[] s = p.split(str);
		for (String string : s) {
			System.out.println(string);
		}
	}
	
	//@Test
	public void test4(){
		String s = "fabckg1274abhjd377abc738abc84";
		String regex = "[a-z]{3,6}";//�ҵ�������λ��ĸ
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		
		while(m.find()){
			String subString = m.group();
			System.out.println(subString);
		}
	
//		m.find();
//		System.out.println(m.start()+"-------"+m.end());
//		m.reset();
//		m.find();
//		System.out.println(m.start()+"-------"+m.end());
	}
	
	//@Test
	public void test5(){
		//���ڱ����˺���Ϣ
		String account = "admin383590dkjik0498jdk984dkjf9345lhgll98853simon3758";
		
		String regex = "([a-zA-Z]{4,6})(\\d{4,6})";//ƥ��һ���˺�
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(account);
		while(m.find()){
//			System.out.println(m.group());//admin383590,dkjik0498,dkjf9345,lhgll98853,simon3758
			System.out.println(m.group(1));//admin,dkjik,dkjf,lhgll,simon
		}
	
	}
	
	//@Test
	public void test6(){
		//����ҵ�񣺻ظ�ok200 ok500���Ӧ��������
		String s = "hjfdok200jfodff888jkok500jhg909";
		String regex = "ok(\\d{1,3})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		double pay = 0;
		while(m.find()){
			pay += Double.valueOf(m.group(1));
		}
		System.out.println(pay);
	}
	
	//@Test
	public void test7(){
		String str = "ahb dk JaVa java jaVa JAva JaVA javA jAVa JAVa jAvA dafd";
		String regex = "java";
		Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		while(m.find()){
			count++;//����Ҿͼ�һ
			if(count%2==0){//ż����ΪJAVA
				m.appendReplacement(buffer, "JAVA");
			}else{//������Ϊjava
				m.appendReplacement(buffer, "java");
			}			
		}
		m.appendTail(buffer);
		System.out.println(buffer);
	}
	
	@Test
	public void test8(){
		//String���replace��Regex���replace�Ա�
		String str = "helle aa helle bb helle cc";
//		String s = str.replaceFirst("helle", "hello");
		String s = str.replaceAll("helle", "hello");
		System.out.println(s);
		
		System.out.println("----------------------------");
		
		String regex = "helle";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
//		String newS = m.replaceFirst("hello");
		String newS = m.replaceAll("hello");
		System.out.println(newS);
		
	}
}
