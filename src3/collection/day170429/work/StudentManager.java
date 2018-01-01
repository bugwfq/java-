package collection.day170429.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {
	private static Properties p = new Properties();
	private static Map<String,Student> stuMap = new HashMap<>();
	private Scanner sc = new Scanner(System.in);
	
	static{
		try {
			p.load(new FileInputStream("src3/day170429/work/studata.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> keys = p.stringPropertyNames();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = p.getProperty(key);
			String[] s = value.split(",");
			Student stu = new Student(s[0],s[1],s[2],s[3],s[4]);
			stuMap.put(stu.getId(), stu);
		}
	}
	
	/**
	 * 
	 * @param oldName��ԭ���İ༶����
	 * @param newName���޸ĺ�İ༶����
	 */
	public static void updateStudents(String oldName,String newName){
		
		if(stuMap.size() == 0){
			return ;
		}
		
		Set<String> keys = stuMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			Student s = stuMap.get(key);
			if(s.getcName().equals(oldName)){
				s.setcName(newName);
			}
		}
	}
	
	/**
	 * 
	 * @param cName��ɾ���İ༶����
	 */
	public static void deleteStudents(String cName){
		if(stuMap.size() == 0){
			return ;
		}
		
		Set<String> keys = stuMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			
			Student s = stuMap.get(key);
			if(s.getcName().equals(cName)){
				stuMap.remove(s.getId());
			}
		}
	}
	
	
	public void addStudent() throws FileNotFoundException, IOException{
	
		System.out.println("������ѧ��id");
		String id = sc.next();
		
		if(stuMap.containsKey(id)){
			System.out.println("ѧ��id�Ѵ���.");
			return ;
		}
		
		System.out.println("������༶����");
		String cName = sc.next();
		
		if(ClassesManager.getClassesByName(cName)==null){
			System.out.println("�ð༶���Ʋ�����.");
			return ;
		}
		
		System.out.println("������ѧ������");
		String name = sc.next();
		
		System.out.println("������ѧ������");
		String age = sc.next();
		
		System.out.println("������ѧ���Ա�");
		String sex = sc.next();
		
		Student s = new Student(id, cName, name, age, sex);
		stuMap.put(s.getId(), s);
		System.out.println("ѧ�������ɹ�.");
		
		p.setProperty(s.getId(), s.getId()+","+s.getcName()+","+s.getName()+","+s.getAge()+","+s.getSex());
	
		p.store(new FileOutputStream("src3/day170429/work/studata.properties"), "student list");
	
	}
	
	public void udpateStudent(){
		System.out.println("��������Ҫ�޸ĵ�ѧ��id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("��Ҫ�޸ĵ�ѧ��id������.");
			return ;
		}
		
		System.out.println("�������µ�ѧ������");
		String newName  = sc.next();
		
		System.out.println("�������µ�ѧ������");
		String newAge = sc.next();
		
		System.out.println("�������µ�ѧ���Ա�");
		String newSex = sc.next();
		
		Student s = stuMap.get(id);
		s.setName(newName);
		s.setAge(newAge);
		s.setSex(newSex);
		
		p.setProperty(s.getId(), s.getId()+","+s.getcName()+","+s.getName()+","+s.getAge()+","+s.getSex());
		
		try {
			p.store(new FileOutputStream("src3/day170429/work/studata.properties"), "student list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�޸ĳɹ�.");
		
	}
	
	public void deleteStudent(){
		System.out.println("��������Ҫɾ����ѧ��id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("��Ҫɾ����ѧ��id������.");
			return ;
		}
		
		stuMap.remove(id);
		p.remove(id);
		try {
			p.store(new FileOutputStream("src3/day170429/work/studata.properties"), "student list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ɾ���ɹ�.");
	}

	public void studentList(){
		
		if(stuMap.size() == 0){
			System.out.println("��ǰû���κ�ѧ����Ϣ.");
			return ;
		}
		
		Set<String> keys = stuMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			System.out.println(stuMap.get(key));
		}
	}
	
	public void querySingleStudent(){
		
		System.out.println("��������Ҫ��ѯ��ѧ��id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("��Ҫ��ѯ��ѧ��id������.");
			return ;
		}
		
		System.out.println(stuMap.get(id));
	}

}
