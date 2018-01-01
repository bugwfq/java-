package collection.day170427.map方法实现班级学生管理;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ClassesManager {
	private Scanner sc = new Scanner(System.in);
	//声明一个班级集合
	public static Map<Integer, Classes> clsMap = new HashMap<>();

	/**
	 * 添加班级
	 */
	public void addClasses(){
		System.out.println("请输入要添加的班级id");
		int clsId = sc.nextInt();
		
		//判断该班级id是否存在
		boolean bool = clsMap.containsKey(clsId);
		if(bool==true){
			System.out.println("要添加的班级id已存在");
			return;
		}
		
		System.out.println("请输入要添加的班级名");
		String clsName = sc.next();
		
		System.out.println("请输入要添加的班级描述");
		String desc = sc.next();
		
		Classes newCls = new Classes(clsId,clsName,desc);
		clsMap.put(clsId, newCls);
		System.out.println("添加成功！");
	}
	
	/**
	 * 删除班级
	 */
	public void deleteClasses(){
		System.out.println("请输入要删除的班级id");
		int clsId = sc.nextInt();
		
		//判断要删除的班级id是否存在
		boolean bool = clsMap.containsKey(clsId);
		if(bool==false){
			System.out.println("要删除的班级id不存在");
			return;
		}
		//同时删除该班级下的学生
		Classes cls = ClassesManager.clsMap.get(clsId);
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				StudentManager.stuMap.remove(id);
			}
		}				
		//删除该班级
		clsMap.remove(clsId);
		System.out.println("删除班级成功！");
	}
	
	/**
	 * 修改班级信息
	 */
	public void updateClasses(){
		System.out.println("请输入要修改的班级id");
		int clsId = sc.nextInt();
		
		//判断要修改的班级id是否存在(返回该班级)
		Classes cls = clsMap.get(clsId);
		if(cls==null){
			System.out.println("要修改的班级id不存在");
			return;
		}
		
		System.out.println("请输入要修改的班级名");
		String clsName = sc.next();
		
		//修改该班级下学生的班级名
		
		Set<Integer>keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				stu.setClsName(clsName);
			}
		}
	
		System.out.println("请输入要修改的班级描述");
		String desc = sc.next();
		
		cls.setClsName(clsName);
		cls.setDesc(desc);
		System.out.println("修改成功！");
	}
	
	/**
	 * 查看单个班级信息
	 */
	public void querySingleClasses(){
		System.out.println("请输入要查看的班级id");
		int clsId = sc.nextInt();
		
		if(clsMap.containsKey(clsId)==false){
			System.out.println("没有该班级id");
			return;
		}
		
		System.out.println(clsMap.get(clsId));
	}
	
	/**
	 * 查看班级信息
	 */
	public void ClassesList(){
		if(clsMap.isEmpty()==true){
			System.out.println("没有任何班级信息");
			return;
		}
		
		Set<Integer> keys = clsMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		
		while(iter.hasNext()){
			Integer clsId = iter.next();
			Classes cls = clsMap.get(clsId);
			System.out.println(cls);
		}
	}
}
