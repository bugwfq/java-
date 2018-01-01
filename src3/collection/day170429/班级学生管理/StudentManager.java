package collection.day170429.班级学生管理;

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
			p.load(new FileInputStream("src3/day170429/班级学生管理/stuData.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//遍历Properties并存储到Map集合
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
	 * 添加学生
	 */
	public void addStudent(){
		
		System.out.println("请输入要添加学生的班级名");
		String cName = sc.next();
		
		if(ClassesManager.getClsByName(cName)==null){
			System.out.println("该班级名不存在");
			return;
		}
		
		System.out.println("请输入要添加的学生id");
		String id = sc.next();
		
		if(stuMap.containsKey(id)){
			System.out.println("该学生id已存在");
			return;
		}
		
		System.out.println("请输入要添加的学生姓名");
		String name = sc.next();
		
		System.out.println("请输入要添加的学生年龄");
		String age = sc.next();
		
		System.out.println("请输入要添加的学生性别");
		String sex = sc.next();
		
		Student stu = new Student(id,cName,name,age,sex);
		stuMap.put(stu.getId(), stu);		
		System.out.println("添加学生成功");
		p.setProperty(stu.getId(), stu.getId()+","+stu.getClsName()+","+stu.getName()+","+stu.getAge()+","+stu.getSex());
		storeFile();
	}

	private void storeFile() {
		try {
			p.store(new FileOutputStream("src3/day170429/班级学生管理/stuData.properties"), "stu list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除学生
	 */
	
	public void deleteStudent(){
		System.out.println("请输入要删除的学生id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("该学生id不存在");
			return;
		}
		
		stuMap.remove(id);
		p.remove(id);
		storeFile();
		
		System.out.println("删除成功");
	}
	
	/**
	 * 通过班级名删除学生
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
	 * 修改学生信息
	 */
	public void updateStudent(){
		System.out.println("请输入要修改的学生id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("该班级id不存在");
			return;
		}
		
		System.out.println("请输入修改后的学生姓名");
		String name = sc.next();
		
		System.out.println("请输入修改后的学生年龄");
		String age = sc.next();
		
		System.out.println("请输入修改后的学生性别");
		String sex = sc.next();
		
		stuMap.get(id).setId(id);
		stuMap.get(id).setName(name);
		stuMap.get(id).setAge(age);
		stuMap.get(id).setSex(sex);
		p.setProperty(id, id+","+name+","+age+","+sex);
		storeFile();
		System.out.println("修改成功");
	}
	

	/**
	 * 查看单个学生
	 */
	public void querySingleStudent(){
		System.out.println("请输入要查看的学生id");
		String id = sc.next();
		
		if(!stuMap.containsKey(id)){
			System.out.println("该学生id不存在");
			return;
		}
		
		System.out.println("要查看的学生信息如下：");
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
	 * 查看所有学生信息
	 */
	public void studentList(){
		if(stuMap.size()==0){
			System.out.println("当前没有任何学生信息");
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
	 * 通过班级名修改学生
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


