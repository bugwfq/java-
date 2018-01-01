package collection.day170429.work;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {

	private static Map<String,User> userMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * �����û��������Σ��ڳ������֮ǰ���ܼ�����¼
	 */
	
	private static Map<String,Integer> errorMap = new HashMap<>();
	
	/**
	 * 
	 * 
	 * admin 2
	 * cc 1
	 */
	
	static {
		/*
		 * admin:����Ȩ��
		 * cc:��ѯȨ�� 
		 */
		
		User adminUser = new User("1", "admin", "admin", 1);
		User commonUser = new User("2", "cc", "cc", 2);
		
		userMap.put(adminUser.getId(), adminUser);
		userMap.put(commonUser.getId(), commonUser);
		System.out.println("���ݳ�ʼ�����...");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		while(true){
			System.out.println("1.��¼2.�˳�");
			int mark = sc.nextInt();
			
			if(mark == 1){
				login();
			}else{
				System.exit(0);
			}
		}
	
		
		
	}

	private static void login() throws FileNotFoundException, IOException {
		System.out.println("�������û���");
		String username = sc.next();
		
		if(errorMap.containsKey(username) && errorMap.get(username)>=3){
			System.out.println("��ǰ�û���¼�Ѿ�����3�Σ����첻�ܵ�¼");
			return ;
		}
		
		
		System.out.println("����������");
		String password = sc.next();
		
		User loginUser = getUserByUnAndPwd(username, password);
		if(loginUser != null){
			
			// ��Ҫ�Ե�¼���������0
			if(errorMap.containsKey(username)){
				errorMap.remove(username);
//				errorMap.put(username, 0);
			}
			
			if(loginUser.getType() == 1){
				adminMenu();
			}else{
				commonMenu();
			}
			
		}else{
			System.out.println("�û���������󣬵�¼ʧ��.");
			
			// ���Ϸ����û�����¼����(admin,cc) dd
			if(getUserByUsername(username)!=null){
				
				// ������û���Ϣ����errorMap��(1.��һ�δ���2.�ڶ�������)
				if(errorMap.containsKey(username)){ // ˵�������Ѿ������˴������
					errorMap.put(username, errorMap.get(username)+1);
				}else{
					errorMap.put(username, 1);
				}
			}
			
			
		}
	}
	
	private static User getUserByUsername(String username){
		
		Set<String> keys = userMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			User user = userMap.get(key);
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		
		return null;
	}
	
	private static User getUserByUnAndPwd(String username,String password){
		
		Set<String> keys = userMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			User user = userMap.get(key);
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		
		return null;
	}
	private static ClassesManager cm = new ClassesManager();
	private static StudentManager sm = new StudentManager();
	/**
	 * ����Ա�˵�
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void adminMenu() throws FileNotFoundException, IOException{
		
		
		while(true){
			System.out.println("1.�༶����2.ѧ������3.�˳�");
			int mark = sc.nextInt();	
			
			if(mark == 1){
				
				while(true){
					System.out.println("1.���Ӱ༶2.ɾ���༶3.��ѯ�༶4.�޸İ༶5.�༶�б�6.������һ��");
					int mark1 = sc.nextInt();
					
					if(mark1 == 1){
						cm.addClasses();
					}else if(mark1 == 2){
						cm.deleteClasses();
					}else if(mark1 == 3){
						cm.querySingleClasses();
					}else if(mark1 == 4){
						cm.updateClasses();
					}else if(mark1 == 5){
						cm.classesList();
					}else{
						break;
					}
					
				}
			}else if(mark == 2){
				while(true){
					System.out.println("1.����ѧ��2.ɾ��ѧ��3.��ѯѧ��4.ѧ���б�5.�޸�ѧ��6.������һ��");
					int mark1 = sc.nextInt();
						
					if(mark1 == 1){
						sm.addStudent();
					}else if(mark1 == 2){
						sm.deleteStudent();
					}else if(mark1 == 3){
						sm.querySingleStudent();
					}else if(mark1 == 4){
						sm.studentList();
					}else if(mark1 == 5){
						sm.udpateStudent();
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
	}
	
	/**
	 * ��ͨ�û��˵�
	 */
	public static void commonMenu(){
		while(true){
			System.out.println("1.�༶����2.ѧ������3.�˳�");
			int mark = sc.nextInt();
			
			if(mark == 1){
				while(true){
					System.out.println("1.�鿴�༶2.�༶�б�3.������һ��");
					int mark1 = sc.nextInt();
						
					if(mark1 == 1){
						cm.querySingleClasses();
					}else if(mark1 == 2){
						cm.classesList();
					}else{
						break;
					}
				}
				
			}else if(mark == 2){
				while(true){
					System.out.println("1.�鿴ѧ��2.ѧ���б�3.������һ��");
					int mark1 = sc.nextInt();
					
					if(mark1 == 1){
						sm.querySingleStudent();
					}else if(mark1 == 2){
						sm.studentList();
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
	}
}
