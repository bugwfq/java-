package net.URL.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ×Ö·û±àÂë
 * @author Administrator
 *
 */
public class URLEncoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = URLEncoder.encode("ÎÒ°®ÄãÖÐ»ª£¡", "UTF-8");
		System.out.println(url);
	}
}
