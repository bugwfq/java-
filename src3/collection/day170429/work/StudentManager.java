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
	 * @param oldName：原来的班级名称
	 * @param newName：修改后的班级名称
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
	 * @param cName：删除的班级名称
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
	
		System.out.println("请输入学生id");
		String id = sc.next();
		
		if(stuMap.containsKey(id)){
			System.out.println("学生id已存在.");
			return ;
		}
		
		System.out.println("请输入班级名称");
		String cName = sc.next();
		
		if(ClassesManager.getClassesByName(cName)==null){
			System.out.println("该班级名称不存在.");
			return ;
		}
		
		System.out.println("请输入学生名字");
		String name = sc.next();
		
		System.out.println("请输入学生年龄");
		String age = sc.next();
		
		System.out.println("请输入学生性别");
		String sex = sc.next();
		
		Student s = new Student(id, cName, name, age, sex);
		stuMap.put(s.getId(), s);
		System.out.println("学生新增成功.");
		
		p.setProperty(s.getId(), s.getId()+","+s.getcName()+","+s.getName()+","+s.getAge()+","+s.getSex());
	
		p.store(new FileOutputStream("src3/day170429/work/studata.properties"), "student list");
	
	}
	
	public void udpateStudent(){
		System.out.println("请输入你要修改的学生id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("你要修改的学生id不存在.");
			return ;
		}
		
		System.out.println("请输入新的学生姓名");
		String newName  = sc.next();
		
		System.out.println("请输入新的学生年龄");
		String newAge = sc.next();
		
		System.out.println("请输入新的学生性别");
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
		System.out.println("修改成功.");
		
	}
	
	public void deleteStudent(){
		System.out.println("请输入你要删除的学生id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("你要删除的学生id不存在.");
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
		System.out.println("删除成功.");
	}

	public void studentList(){
		
		if(stuMap.size() == 0){
			System.out.println("当前没有任何学生信息.");
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
		
		System.out.println("请输入你要查询的学生id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("你要查询的学生id不存在.");
			return ;
		}
		
		System.out.println(stuMap.get(id));
	}

}
