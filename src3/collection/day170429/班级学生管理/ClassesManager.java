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

public class ClassesManager {
	private static Map<String,Classes> clsMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	private static Properties p = new Properties();
	
	static{
		try {
			p.load(new FileInputStream("src3/day170429/�༶ѧ������/clsData.properties"));
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
			Classes c = new Classes(s[0],s[1],s[2]);
			clsMap.put(c.getId(), c);
		}
		
	}
	/**
	 * ��Ӱ༶
	 */
	public void addClasses(){
		System.out.println("������Ҫ��ӵİ༶id");
		String id = sc.next();
		
		if(clsMap.containsKey(id)){
			System.out.println("�ð༶id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵİ༶��");
		String name = sc.next();
		
		if(getClsByName(name)!=null){
			System.out.println("�ð༶���Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵİ༶����");
		String desc = sc.next();
		
		Classes cls = new Classes(id,name,desc);
		clsMap.put(cls.getId(), cls);		
		System.out.println("��Ӱ༶�ɹ�");
		p.setProperty(cls.getId(), cls.getId()+","+cls.getClsName()+","+cls.getDesc());
		storeFile();
	}

	private void storeFile() {
		try {
			p.store(new FileOutputStream("src3/day170429/�༶ѧ������/clsData.properties"), "cls list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ɾ���༶
	 */
	
	public void deleteClasses(){
		System.out.println("������Ҫɾ���İ༶id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("�ð༶id������");
			return;
		}
		
		Classes c = clsMap.remove(id);
		p.remove(id);
		storeFile();
		//����ɾ��
		StudentManager.deleteStudent(c.getClsName());
		System.out.println("ɾ���ɹ�");
	}
	
	/**
	 * �޸İ༶��Ϣ
	 */
	public void updateClasses(){
		System.out.println("������Ҫ�޸ĵİ༶id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("�ð༶id������");
			return;
		}
		
		System.out.println("�������޸ĺ�İ༶��");
		String newName = sc.next();
		
		if(getClsByName(newName)!=null){
			System.out.println("�ð༶���Ѵ���");
			return;
		}
		
		System.out.println("�������޸ĺ�İ༶����");
		String desc = sc.next();
		
		//�����޸�ѧ���༶��
		String oldName = clsMap.get(id).getClsName();		
		StudentManager.updateStuByCName(oldName, newName);
		
		clsMap.get(id).setClsName(newName);
		clsMap.get(id).setDesc(desc);
		p.setProperty(id, id+","+newName+","+desc);
		storeFile();
		System.out.println("�޸ĳɹ�");
	}
	

	/**
	 * �鿴�����༶
	 */
	public void querySingleClasses(){
		System.out.println("������Ҫ�鿴�İ༶id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("�ð༶id������");
			return;
		}
		
		System.out.println("Ҫ�鿴�İ༶��Ϣ���£�");
		Set<String> keys = clsMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			Classes cls = clsMap.get(key);
			if(cls.getId().equals(id)){
				System.out.println(cls);
			}
					
		}
	}
	
	/**
	 * �鿴���а༶��Ϣ
	 */
	public void ClassesList(){
		if(clsMap.size()==0){
			System.out.println("��ǰû���κΰ༶��Ϣ");
			return;
		}
		
		Set<String> keys = clsMap.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			Classes c = clsMap.get(key);
			System.out.println(c);
		}
	}
	
	
	/**
	 * ͨ���༶����ȡ�༶
	 */
	public static Classes getClsByName(String clsName){
		if(clsMap.size()==0){
			return null;
		}
		
		Set<String> keys = clsMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			Classes cls = clsMap.get(key);
			if(cls.getClsName().equals(clsName)){
				return cls;
			}
		}
		return null;
	}
	
}
