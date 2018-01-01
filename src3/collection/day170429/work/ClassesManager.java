package collection.day170429.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class ClassesManager {
	private static Properties p = new Properties();
	private static Map<String,Classes> clsMap = new HashMap<>();
	private Scanner sc = new Scanner(System.in);
	
	
	static{
		try {
			p.load(new FileInputStream("src3/day170429/work/clsdata.properties"));
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
			Classes cls = new Classes(s[0],s[1],s[2]);
			clsMap.put(cls.getId(), cls);
		}
		
	}
	public void addClasses() throws FileNotFoundException, IOException{
		System.out.println("������༶id");
		String id = sc.next();
		
		if(clsMap.containsKey(id)){
			System.out.println("�ð༶id�Ѵ���.");
			return ;
		}
		
		System.out.println("������༶����");	
		String name = sc.next();
		
		if(getClassesByName(name)!=null){
			System.out.println("�ð༶�����Ѵ���.");
			return ;
		}
		
		System.out.println("������༶����");
		String desc = sc.next();
		
		Classes newC = new Classes(id, name, desc);
		clsMap.put(newC.getId(), newC);
		System.out.println("�༶��ӳɹ�.");
		
		p.setProperty(newC.getId(), newC.getId()+","+newC.getName()+","+newC.getDesc());
		
		p.store(new FileOutputStream("src3/day170429/work/clsdata.properties"), "classes list");

	}
	
	public void querySingleClasses(){
		System.out.println("��������Ҫ��ѯ�İ༶id:");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("��Ҫ���ҵİ༶id������.");
			return ;
		}
		
		System.out.println(clsMap.get(id));
	}
	
	public void classesList(){
		if(clsMap.size() == 0){
			System.out.println("��ǰû���κΰ༶��Ϣ.");
			return ;
		}
		
		System.out.println("�༶��Ϣ����:");
		Set<String> keys = clsMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			System.out.println(clsMap.get(key));
		}
	}
	
	public void updateClasses(){
		System.out.println("��������Ҫ�޸ĵİ༶id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("��Ҫ�޸ĵİ༶id������.");
			return ;
		}
		
		System.out.println("�������µİ༶����");
		String newName = sc.next();
		
		if(getClassesByName(newName)!=null){
			System.out.println("�µİ༶�����Ѵ���.");
			return ;
		}
		
		System.out.println("�������µİ༶����");
		String newDesc = sc.next();
		
		
		Classes c = clsMap.get(id);
		String oldName = c.getName(); 
		c.setName(newName);
		c.setDesc(newDesc);
		p.setProperty(c.getId(), c.getId()+","+c.getName()+","+c.getDesc());//һ��������put!!!!
		try {
			p.store(new FileOutputStream("src3/day170429/work/clsdata.properties"), "classes list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����޸�ѧ����Ӧ�İ༶���� (oldName,newName)
		StudentManager.updateStudents(oldName, newName); // �����޸�
		
		System.out.println("�޸ĳɹ�.");
		
	}
	
	public void deleteClasses(){
		System.out.println("��������Ҫɾ���İ༶id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("��Ҫɾ���İ༶id������.");
			return ;
		}
		
		// ����ɾ��(oldName)
		String oldName = clsMap.get(id).getName();
		StudentManager.deleteStudents(oldName); //  ����ɾ��
		clsMap.remove(id);
		p.remove(id);
		try {
			p.store(new FileOutputStream("src3/day170429/work/clsdata.properties"), "classes list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ɾ���ɹ�.");
	}
	
	public static  Classes getClassesByName(String name){
		
		if(clsMap.size() == 0){
			return null;
		}
		
		Set<String> keys = clsMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			
			Classes c = clsMap.get(key);
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
}
