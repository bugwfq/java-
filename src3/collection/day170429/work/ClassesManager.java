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
		System.out.println("请输入班级id");
		String id = sc.next();
		
		if(clsMap.containsKey(id)){
			System.out.println("该班级id已存在.");
			return ;
		}
		
		System.out.println("请输入班级名称");	
		String name = sc.next();
		
		if(getClassesByName(name)!=null){
			System.out.println("该班级名称已存在.");
			return ;
		}
		
		System.out.println("请输入班级描述");
		String desc = sc.next();
		
		Classes newC = new Classes(id, name, desc);
		clsMap.put(newC.getId(), newC);
		System.out.println("班级添加成功.");
		
		p.setProperty(newC.getId(), newC.getId()+","+newC.getName()+","+newC.getDesc());
		
		p.store(new FileOutputStream("src3/day170429/work/clsdata.properties"), "classes list");

	}
	
	public void querySingleClasses(){
		System.out.println("请输入你要查询的班级id:");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("你要查找的班级id不存在.");
			return ;
		}
		
		System.out.println(clsMap.get(id));
	}
	
	public void classesList(){
		if(clsMap.size() == 0){
			System.out.println("当前没有任何班级信息.");
			return ;
		}
		
		System.out.println("班级信息如下:");
		Set<String> keys = clsMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			System.out.println(clsMap.get(key));
		}
	}
	
	public void updateClasses(){
		System.out.println("请输入你要修改的班级id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("你要修改的班级id不存在.");
			return ;
		}
		
		System.out.println("请输入新的班级名称");
		String newName = sc.next();
		
		if(getClassesByName(newName)!=null){
			System.out.println("新的班级名称已存在.");
			return ;
		}
		
		System.out.println("请输入新的班级描述");
		String newDesc = sc.next();
		
		
		Classes c = clsMap.get(id);
		String oldName = c.getName(); 
		c.setName(newName);
		c.setDesc(newDesc);
		p.setProperty(c.getId(), c.getId()+","+c.getName()+","+c.getDesc());//一定不能用put!!!!
		try {
			p.store(new FileOutputStream("src3/day170429/work/clsdata.properties"), "classes list");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 级联修改学生对应的班级名称 (oldName,newName)
		StudentManager.updateStudents(oldName, newName); // 级联修改
		
		System.out.println("修改成功.");
		
	}
	
	public void deleteClasses(){
		System.out.println("请输入你要删除的班级id");
		String id = sc.next();
		
		if(!clsMap.containsKey(id)){
			System.out.println("你要删除的班级id不存在.");
			return ;
		}
		
		// 级联删除(oldName)
		String oldName = clsMap.get(id).getName();
		StudentManager.deleteStudents(oldName); //  级联删除
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
		System.out.println("删除成功.");
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
