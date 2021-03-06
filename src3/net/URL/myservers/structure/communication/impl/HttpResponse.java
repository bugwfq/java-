package net.URL.myservers.structure.communication.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

import net.URL.myservers.structure.communication.Response;
import net.URL.myservers.structure.servlet.IndexServlet;
import net.URL.myservers.structure.servlet.ServletInterfaces;

public class HttpResponse implements Response{
	private BufferedOutputStream bw;
	public HttpResponse(){}
	public HttpResponse(Socket socket){
		try {
			this.bw = new BufferedOutputStream(socket.getOutputStream(),61858764);
		} catch (IOException e) {
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * 根据路径写回返回消息
	 * @param url
	 *
	 */
	@Override
	public void response(String url) {
		
		File file = null;
		ServletInterfaces servlet = null;
		if(url.equals("/")){
			file = isFile("index.html");
			servlet = new IndexServlet(file);
			servlet.writer(bw);
		}else if(url.contains("?")){
			if(url.endsWith(".do?")){
				if(url.startsWith("add")){
					
				}else if(url.startsWith("delete")){
					
				}else if(url.startsWith("update")){
					
				}else if(url.startsWith("find")){
					
				}else if(url.startsWith("userlist")){
					
				}
			}
			
		}else if(url.matches("(.+/.*)*.+\\..\\w+")){
			file = isFile(url);
			
			if(!file.exists()){
				Properties pro = new Properties();
				try {
					pro.load(new FileInputStream(new File("src3/net/URL/myservers/configuration/configuration.properties")));
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				String fileRootPath = pro.getProperty("fileRootPath");
				String notfound = pro.getProperty("notfound");
				file = new File(fileRootPath+notfound);
			}
			
			servlet = new IndexServlet(file);
			servlet.writer(bw);
		}
		System.out.println(url);
	}
	
	private File isFile(String url) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File("src3/net/URL/myservers/configuration/configuration.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileRootPath = pro.getProperty("fileRootPath");
		File file = new File(fileRootPath+url);
		return file;
	}
}
