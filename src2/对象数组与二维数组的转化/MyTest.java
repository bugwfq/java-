package 对象数组与二维数组的转化;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		//创建对象数组
		User[] user = new User[10];
		//创建二维数组
		String[][] str = new String[10][2];
		//对象数组转二维数组
		for(int i=0;i<user.length;i++){
			str[i][0] = user[i].getUserName();
			str[i][1] = user[i].getPassword();
		}
		//二维数组转对象数组
		for(int i=0;i<str.length;i++){
			user[i].setUserName(str[i][0]);
			user[i].setPassword(str[i][1]);
		}
		
	}
}
