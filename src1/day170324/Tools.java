package day170324;

public class Tools {

	public static User getUserByUsername(String username){//ͨ���û�����ȡ�û�
		
		User user = null;
		for(int i = 0;i<UserManager.index;i++){
			if(UserManager.users[i].getUsername().equals(username)){
				user = UserManager.users[i];
				break;
			}
		}
		return user;
	}
	
	public static User getUserByUnAndPwd(String username,String password){//ͨ���û����������ȡ�û�
			
			User user = null;
			for(int i = 0;i<UserManager.index;i++){
				if(UserManager.users[i].getUsername().equals(username) && UserManager.users[i].getPassword().equals(password)){
					user = UserManager.users[i];
					break;
				}
			}
			return user;
		}

	public static User getUserById(int id){//ͨ���û�id��ȡ�û�
		
		User user = null;
		for(int i = 0;i<UserManager.index;i++){
			if(UserManager.users[i].getId() == id){
				user = UserManager.users[i];
				break;
			}
		}
		return user;
	}
	
	public static ErrorLoginInfo getErrorLoginInfoByUsername(String username){//ͨ���û�����ȡ�����¼��Ϣ
		ErrorLoginInfo eli = null;
		for(int i = 0;i<Test.index;i++){
			if(Test.elis[i].getUsername().equals(username)){
				eli = Test.elis[i];
				break;
			}
		}
		
		return eli;
	}
}
