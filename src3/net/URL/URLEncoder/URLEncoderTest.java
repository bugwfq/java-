package net.URL.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * �ַ�����
 * @author Administrator
 *
 */
public class URLEncoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = URLEncoder.encode("�Ұ����л���", "UTF-8");
		System.out.println(url);
	}
}
