package day170324;

public class Tools {

	public static User getUserByUsername(String username){//通过用户名获取用户
		
		User user = null;
		for(int i = 0;i<UserManager.index;i++){
			if(UserManager.users[i].getUsername().equals(username)){
				user = UserManager.users[i];
				break;
			}
		}
		return user;
	}
	
	public static User getUserByUnAndPwd(String username,String password){//通过用户名和密码获取用户
			
			User user = null;
			for(int i = 0;i<UserManager.index;i++){
				if(UserManager.users[i].getUsername().equals(username) && UserManager.users[i].getPassword().equals(password)){
					user = UserManager.users[i];
					break;
				}
			}
			return user;
		}

	public static User getUserById(int id){//通过用户id获取用户
		
		User user = null;
		for(int i = 0;i<UserManager.index;i++){
			if(UserManager.users[i].getId() == id){
				user = UserManager.users[i];
				break;
			}
		}
		return user;
	}
	
	public static ErrorLoginInfo getErrorLoginInfoByUsername(String username){//通过用户名获取错误登录信息
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
