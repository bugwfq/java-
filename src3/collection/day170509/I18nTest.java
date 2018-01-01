package collection.day170509;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.junit.Test;

public class I18nTest {
	//@Test
	public void test(){
		//û��ָ���ļ���Ĭ�ϴ洢������
		ResourceBundle bundle = ResourceBundle.getBundle("mess",Locale.CHINA);
			
		//��ȡ�ַ���
		String str = bundle.getString("loginUser");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//ͨ��MessageFormat.format������ȡ�ַ������и�ʽ��
		String newStr = MessageFormat.format(str, "admin",sdf.format(new Date()));
		System.out.println(newStr);
	}
	
	//@Test
	public void test2(){
		Locale[] ls = Locale.getAvailableLocales();
		
		for(Locale i:ls){
			System.out.println(i.getLanguage()+"-"+i.getCountry());
		}
	}
	
	@Test
	public void test3(){
		ResourceBundle bundle = ResourceBundle.getBundle("mess", Locale.CHINA);
		String str = bundle.getString("loginUser");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newStr = MessageFormat.format(str,"admin",sdf.format(new Date()));
		System.out.println(newStr);
		
	}
}
