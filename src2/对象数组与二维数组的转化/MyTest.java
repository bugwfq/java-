package �����������ά�����ת��;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		//������������
		User[] user = new User[10];
		//������ά����
		String[][] str = new String[10][2];
		//��������ת��ά����
		for(int i=0;i<user.length;i++){
			str[i][0] = user[i].getUserName();
			str[i][1] = user[i].getPassword();
		}
		//��ά����ת��������
		for(int i=0;i<str.length;i++){
			user[i].setUserName(str[i][0]);
			user[i].setPassword(str[i][1]);
		}
		
	}
}
