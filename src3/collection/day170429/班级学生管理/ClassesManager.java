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

public class ClassesManager {
	private static Map<String,Classes> clsMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	private static Properties p = new Properties();
	
	static{
		try {
			p.load(new FileInputStream("src3/day170429/班级学生管理/clsData.properties"));
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
			Classes c = new Classes(s[0],s[1],s[2]);
			clsMap.put(c.getId(), c);
		}
		
	}
	/**
	 * 添加班级
	 */
	public void addClasses(){
		System.out.println("请输入要添加的班级id");
		String id = sc.next();
		
		if(clsMap.containsKey(id)){
			System.out.println("该班级id已存在");
			return;
		}
		
		System.out.println("请输入要添加的班级名");
		String name = sc.next();
		
		if(getClsByName(name)!=null){
			System.out.println("该班级名已存在");
			return;
		}
		
		System.out.println("请输入要添加的班级描述");
		String desc = sc.next();
		
		Classes cls = new Classes(id,name,desc);
		clsMap.put(cls.getId(), cls);		
		System.out.println("添加班级成功");
		p.setProperty(cls.getId(), cls.getId()+","+cls.getClsName()+","+cls.getDesc());
		storeFile();
	}

	private void storeFile() {
		try {
			p.store(new FileOutputStream("src3/day170429/班级学生管理/clsData.properties"), "cls list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除班级
	 */
	
	public void deleteClasses(){
		System.out.println("请输入要删除的班级id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("该班级id不存在");
			return;
		}
		
		Classes c = clsMap.remove(id);
		p.remove(id);
		storeFile();
		//级联删除
		StudentManager.deleteStudent(c.getClsName());
		System.out.println("删除成功");
	}
	
	/**
	 * 修改班级信息
	 */
	public void updateClasses(){
		System.out.println("请输入要修改的班级id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("该班级id不存在");
			return;
		}
		
		System.out.println("请输入修改后的班级名");
		String newName = sc.next();
		
		if(getClsByName(newName)!=null){
			System.out.println("该班级名已存在");
			return;
		}
		
		System.out.println("请输入修改后的班级描述");
		String desc = sc.next();
		
		//级联修改学生班级名
		String oldName = clsMap.get(id).getClsName();		
		StudentManager.updateStuByCName(oldName, newName);
		
		clsMap.get(id).setClsName(newName);
		clsMap.get(id).setDesc(desc);
		p.setProperty(id, id+","+newName+","+desc);
		storeFile();
		System.out.println("修改成功");
	}
	

	/**
	 * 查看单个班级
	 */
	public void querySingleClasses(){
		System.out.println("请输入要查看的班级id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("该班级id不存在");
			return;
		}
		
		System.out.println("要查看的班级信息如下：");
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
	 * 查看所有班级信息
	 */
	public void ClassesList(){
		if(clsMap.size()==0){
			System.out.println("当前没有任何班级信息");
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
	 * 通过班级名获取班级
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
