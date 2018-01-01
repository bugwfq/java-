package net.URL.URLDecoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * ×Ö·û½âÂë
 * @author Administrator
 *
 */
public class URLDecoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = URLDecoder.decode("%E6%88%91%E7%88%B1%E4%BD%A0%E4%B8%AD%E5%8D%8E%EF%BC%81", "UTF-8");
		System.out.println(url);
	}
}
