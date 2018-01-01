package collection.day170429.�༶ѧ������;

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
	private static Map<String,Student> stuMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	private static Properties p = new Properties();
	
	static{
		try {
			p.load(new FileInputStream("src3/day170429/�༶ѧ������/stuData.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����Properties���洢��Map����
		Set<String> keys = p.stringPropertyNames();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			String value = p.getProperty(key);
			String[] s = value.split(",");
			Student stu = new Student(s[0],s[1],s[2],s[3],s[4]);
			stuMap.put(stu.getId(), stu);
		}
		
	}
	/**
	 * ���ѧ��
	 */
	public void addStudent(){
		
		System.out.println("������Ҫ���ѧ���İ༶��");
		String cName = sc.next();
		
		if(ClassesManager.getClsByName(cName)==null){
			System.out.println("�ð༶��������");
			return;
		}
		
		System.out.println("������Ҫ��ӵ�ѧ��id");
		String id = sc.next();
		
		if(stuMap.containsKey(id)){
			System.out.println("��ѧ��id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ�ѧ������");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ�ѧ������");
		String age = sc.next();
		
		System.out.println("������Ҫ��ӵ�ѧ���Ա�");
		String sex = sc.next();
		
		Student stu = new Student(id,cName,name,age,sex);
		stuMap.put(stu.getId(), stu);		
		System.out.println("���ѧ���ɹ�");
		p.setProperty(stu.getId(), stu.getId()+","+stu.getClsName()+","+stu.getName()+","+stu.getAge()+","+stu.getSex());
		storeFile();
	}

	private void storeFile() {
		try {
			p.store(new FileOutputStream("src3/day170429/�༶ѧ������/stuData.properties"), "stu list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ɾ��ѧ��
	 */
	
	public void deleteStudent(){
		System.out.println("������Ҫɾ����ѧ��id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("��ѧ��id������");
			return;
		}
		
		stuMap.remove(id);
		p.remove(id);
		storeFile();
		
		System.out.println("ɾ���ɹ�");
	}
	
	/**
	 * ͨ���༶��ɾ��ѧ��
	 */
	public static void deleteStudent(String clsName){
		Set<String> keys = stuMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			Student s = stuMap.get(key);
			if(s.getClsName().equals(clsName)){
				stuMap.remove(s.getId());
			}
		}
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void updateStudent(){
		System.out.println("������Ҫ�޸ĵ�ѧ��id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("�ð༶id������");
			return;
		}
		
		System.out.println("�������޸ĺ��ѧ������");
		String name = sc.next();
		
		System.out.println("�������޸ĺ��ѧ������");
		String age = sc.next();
		
		System.out.println("�������޸ĺ��ѧ���Ա�");
		String sex = sc.next();
		
		stuMap.get(id).setId(id);
		stuMap.get(id).setName(name);
		stuMap.get(id).setAge(age);
		stuMap.get(id).setSex(sex);
		p.setProperty(id, id+","+name+","+age+","+sex);
		storeFile();
		System.out.println("�޸ĳɹ�");
	}
	

	/**
	 * �鿴����ѧ��
	 */
	public void querySingleStudent(){
		System.out.println("������Ҫ�鿴��ѧ��id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("��ѧ��id������");
			return;
		}
		
		System.out.println("Ҫ�鿴��ѧ����Ϣ���£�");
		Set<String> keys = stuMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			Student stu = stuMap.get(key);
			if(stu.getId().equals(id)){
				System.out.println(stu);
			}
					
		}
	}
	
	/**
	 * �鿴����ѧ����Ϣ
	 */
	public void studentList(){
		if(stuMap.size()==0){
			System.out.println("��ǰû���κ�ѧ����Ϣ");
			return;
		}
		
		Set<String> keys = stuMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			Student stu = stuMap.get(key);
			System.out.println(stu);		
		}
	}
	
	/**
	 * ͨ���༶���޸�ѧ��
	 */
	public static void updateStuByCName(String clsName,String newName){
		if(stuMap.size()==0){
			return;
		}
		
		Set<String> keys = stuMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			Student stu = stuMap.get(key);
			if(stu.getClsName().equals(clsName)){
				stu.setClsName(newName);
			}
		}
	}
	
}


