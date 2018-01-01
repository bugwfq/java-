package collection.day170508;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UserManager {
	
	private static Map<Long, User> userMap = new HashMap<>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	/**
	 * 数据加载
	 */
	
	static{
		//创建Properties对象
		Properties p = new Properties();
		//将Properties对象读入Properties文件
		try {
			p.load(new FileInputStream("src3/day170508/user.properties"));
			
			Set<String> keys = p.stringPropertyNames();
			for(Iterator<String> iter = keys.iterator();iter.hasNext();){
				String key = iter.next();
				String value = p.getProperty(key);
				String[] s = value.split(",");
				String userType = s[3];//固定存储用户类型
				User user = null;
				if(userType.equals("1")){
					long id = Long.valueOf(s[0]);
					String username = s[1];
					String password = s[2];
					int type = Integer.valueOf(s[3]);
					try {
						Date resDate = sdf.parse(s[4]);
						String remark = s[5];
						user = new Admin(id, username, password, remark, type, resDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					
					
					
				}else if(userType.equals("2")){
					
				}else{
					
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 数据存储
	 */
	
}
