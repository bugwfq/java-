package exception.day170525;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MyRegexTest {
	//@Test
	public void test1(){
		//ƥ��6������
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
		Pattern p = Pattern.compile(regex);//����������ʽ
		String[] s = p.split(str);//��ָ��������ʽ����ַ���
		for (String temp : s) {
			System.out.println(temp);
		}
	}
	
	//@Test
	public void test3(){
		// �����ַ�������4-6λ�����Ӵ�
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
		// ���ڱ����˺���Ϣ(�˺���4-6λ��ĸ��ɵ��û�����������4-6λ�������)��admin1234
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
		// �뽫����ַ��������Ϸ��˺���ȡ����
		String str = "admin123456kdjl3325lnk890ljdf3283ikdf5933922kfji00538lm095898djfij589simon85985";
		String regex = "([a-zA-Z]{4,6})(\\d{4,6})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while(m.find()){
//			System.out.println(m.group(1));	
			System.out.println(m.group(2));
		}
		
		m.find(1);//1�Ǵ�ָ��������ʼ
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
			if(count%2==0){//ż��
				m.appendReplacement(buffer,"JAVA");
			}else{//����
				m.appendReplacement(buffer, "java");
			}
		}
		
		m.appendTail(buffer);
		System.out.println(buffer);
	}
	

	//@Test
	public void test7(){
		//�Ƚ�String��Matcher�е�replaceFirst������replaceAll����
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
//			m.reset(str);//����ѭ��
			System.out.println(m.start()+"----"+m.end());
		}*/
		m.find();
		m.reset();
		m.find();
		System.out.println(m.group());
	}
}
