package collection.day170427.map����ʵ�ְ༶ѧ������;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
	
	private static Scanner sc = new Scanner(System.in);
	private static ClassesManager cm = new ClassesManager();
	private static StudentManager sm = new StudentManager();
	private static ReportManager rm = new ReportManager();
	
	private static Map<Integer, User> userMap = new HashMap<>();
	private static Map<String,Integer> errorMap = new HashMap<>();
	
	static {
		User admin = new User(1,"1","1",1);
		User common = new User(2,"2","2",2);
		userMap.put(admin.getId(), admin);
		userMap.put(common.getId(), common);
	}
	
	public static void main(String[] args) {
		while(true){
			System.out.println("1.��¼2.ע��0.�˳�");
			int mark = sc.nextInt();
			if(mark==ConstantInterface.LOGIN){
				login();
			}else if(mark==ConstantInterface.ADDUSER){
				addUser();
			}else {
				System.exit(ConstantInterface.EXIT);
			}
		}
	}
	
	/**
	 * �û�ע��
	 */
	
	public static void addUser(){
		System.out.println("������Ҫע����û�id");
		int id =sc.nextInt();
		
		if(userMap.containsKey(id)==true){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫע����û���");
		String userName = sc.next();
		if(getUserByName(userName)!=null){
			System.out.println("���û�����ע��");
			return;
		}
		
		System.out.println("������Ҫע����û�����");
		String password = sc.next();
		
		System.out.println("��ѡ��Ҫע����û��ȼ�:1.����Ա2.��ͨ�û�");
		int type = sc.nextInt();
		User user = new User(id,userName,password,type);
		userMap.put(id, user);
		System.out.println("ע��ɹ���");
	}
	
	/**
	 * ��¼
	 */
	
	public static void login(){
		System.out.println("�������û���");
		String userName = sc.next();
		
		if(errorMap.containsKey(userName) && errorMap.get(userName)>=3){
			System.out.println("��ǰ�û���¼�Ѿ�����3�Σ����첻�ܵ�¼");
			return;
		}
		
		System.out.println("�������û�����");
		String password = sc.next();
		
		User user = getUserByUnAndPw(userName,password);
		if(user != null){
			
			// ��Ҫ�Ե�¼���������0
			if(errorMap.containsKey(userName)){
				errorMap.remove(userName);
//				errorMap.put(userName, 0);
			}
			
			if(user.getType()==ConstantInterface.ADMINMENU){
				adminMenu();
			}else{
				commonMenu();
			}
			
		}else{
			System.out.println("�û���������󣬵�¼ʧ��.");
			
			// ���Ϸ����û�����¼����(admin,cc) dd
			if(getUserByName(userName)!=null){
				
				// ������û���Ϣ����errorMap��(1.��һ�δ���2.�ڶ�������)
				if(errorMap.containsKey(userName)){ // ˵�������Ѿ������˴������
					errorMap.put(userName, errorMap.get(userName)+1);
				}else{
					errorMap.put(userName, 1);
				}
			}
		}
	}
	
	/**
	 * ͨ���û�����ȡ�û�
	 */
	
	public static User getUserByName(String userName){
		Set<Integer> keys = userMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			User user = userMap.get(key);
			if(user.getName().equals(userName)){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * ͨ���û����������ȡ�û�
	 */
	
	public static User getUserByUnAndPw(String userName,String password){
		Set<Integer> keys = userMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			User user = userMap.get(key);
			if(user.getName().equals(userName) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * ����Ա�˵�
	 */
	public static void adminMenu(){
		while(true){
			System.out.println("1.�༶����2.ѧ������3.��������0.�˳�");
			int mark = sc.nextInt();
			if(mark==ConstantInterface.CLASSESMANAGER){
				while(true){
					System.out.println("1.��Ӱ༶2.ɾ���༶3.�޸İ༶��Ϣ4.�鿴�����༶��Ϣ5.�鿴�༶��Ϣ0.������һ��");
					int mark1 = sc.nextInt();
					if(mark1==ConstantInterface.ADMIN_ADD_CLASSES){
						cm.addClasses();
					}else if(mark1==ConstantInterface.ADMIN_DELETE_CLASSES){
						cm.deleteClasses();
					}else if(mark1==ConstantInterface.ADMIN_UPDATE_CLASSES){
						cm.updateClasses();
					}else if(mark1==ConstantInterface.ADMIN_QUERY_SINGLE_CLASSES){
						cm.querySingleClasses();
					}else if(mark1==ConstantInterface.ADMIN_CLASSES_LIST){
						cm.ClassesList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.STUDENTMANAGER){
				while(true){
					System.out.println("1.���ѧ��2.ɾ��ѧ��3.�޸�ѧ����Ϣ4.�鿴����ѧ����Ϣ5.�鿴ѧ����Ϣ0.������һ��");
					int mark2 = sc.nextInt();
					if(mark2==ConstantInterface.ADMIN_ADD_STUDENT){
						sm.addStudent();
					}else if(mark2==ConstantInterface.ADMIN_DELETE_STUDENT){
						sm.deleteStudent();
					}else if(mark2==ConstantInterface.ADMIN_UPDATE_STUDENT){
						sm.updateStudent();
					}else if(mark2==ConstantInterface.ADMIN_QUERY_SINGLE_STUDENT){
						sm.querySingleStudent();
					}else if(mark2==ConstantInterface.ADMIN_STUDENT_LIST){
						sm.studentList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.REPORTMANAGER){
				while(true){
					System.out.println("1.�鿴ĳ���༶���µ���Ů����2.�鿴ĳ�༶���µ�������䣬��С���䣬ƽ������3.ͳ��ȫУ��Ů����4.�鿴ȫУ���������ѧ������С�����ѧ��0.������һ��");
					int mark3 = sc.nextInt();
					if(mark3==ConstantInterface.QUERYBOYSANDGIRLSBYCLSID){
						System.out.println("������Ҫ�鿴�İ༶id");
						int clsId = sc.nextInt();
						rm.queryBoysAndGirlsByClsId(clsId);
					}else if(mark3==ConstantInterface.QUERYMAXAGEVSMINAGEVSAVERAGEAGE){
						System.out.println("������Ҫ�鿴�İ༶id");
						int clsId = sc.nextInt();
						rm.queryMaxAgeVsMinAgeVsAverageAge(clsId);
					}else if(mark3==ConstantInterface.QUERYALLBOYSANDGIRLS){
						rm.queryAllBoysAndGirls();
					}else if(mark3==ConstantInterface.QUERYMAXAGESTUANDMINAGESTU){
						rm.queryMaxAgeStuAndMinAgeStu();
					}else{
						break;
					}
				}	
			}else{
				System.exit(ConstantInterface.EXIT);
			}
		}
	}
	
	
	
	/**
	 *��ͨ�û��˵� 
	 */
	public static void commonMenu(){
		while(true){
			System.out.println("1.�༶����2.ѧ������3.��������0.�˳�");
			int mark = sc.nextInt();
			if(mark==ConstantInterface.CLASSESMANAGER){
				while(true){
					System.out.println("1.�鿴�����༶��Ϣ2.�鿴���а༶��Ϣ0.������һ��");
					int mark1 = sc.nextInt();
					if(mark1==ConstantInterface.COMMON_QUERY_SINGLE_CLASSES){
						cm.querySingleClasses();
					}else if(mark1==ConstantInterface.COMMON_CLASSES_LIST){
						cm.ClassesList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.STUDENTMANAGER){
				while(true){
					System.out.println("1.�鿴����ѧ����Ϣ2.�鿴����ѧ����Ϣ0.������һ��");
					int mark2 = sc.nextInt();
					if(mark2==ConstantInterface.COMMON_QUERY_SINGLE_STUDENT){
						sm.querySingleStudent();
					}else if(mark2==ConstantInterface.COMMON_STUDENT_LIST){
						sm.studentList();
					}else{
						break;
					}
				}
			}else if(mark==ConstantInterface.REPORTMANAGER){
				while(true){
					System.out.println("1.�鿴ĳ���༶���µ���Ů����2.�鿴ĳ�༶���µ�������䣬��С���䣬ƽ������3.ͳ��ȫУ��Ů����4.�鿴ȫУ���������ѧ������С�����ѧ��0.������һ��");
					int mark3 = sc.nextInt();
					if(mark3==ConstantInterface.QUERYBOYSANDGIRLSBYCLSID){
						System.out.println("������Ҫ�鿴�İ༶id");
						int clsId = sc.nextInt();
						rm.queryBoysAndGirlsByClsId(clsId);
					}else if(mark3==ConstantInterface.QUERYMAXAGEVSMINAGEVSAVERAGEAGE){
						System.out.println("������Ҫ�鿴�İ༶id");
						int clsId = sc.nextInt();
						rm.queryMaxAgeVsMinAgeVsAverageAge(clsId);
					}else if(mark3==ConstantInterface.QUERYALLBOYSANDGIRLS){
						rm.queryAllBoysAndGirls();
					}else if(mark3==ConstantInterface.QUERYMAXAGESTUANDMINAGESTU){
						rm.queryMaxAgeStuAndMinAgeStu();
					}else{
						break;
					}
				}	
			}else{
				System.exit(ConstantInterface.EXIT);
			}
		}
	}
}
