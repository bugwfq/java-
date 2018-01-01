package 对象数组的增删改查级联;

import java.util.Scanner;

public class ClassesManager {
	public static Classes[] cls = new Classes[10];
	public static int index = 0;
	public Scanner sc = new Scanner(System.in);
	/**
	 * 添加班级
	 */
	public void addClasses(){
		System.out.println("请输入要添加的班级id");
		int clsId = sc.nextInt();
		
		//判断该班级id是否存在
		Classes c = Tools.getClssesByClsId(clsId);
		if(c!=null){
			System.out.println("该班级id已存在");
			return;
		}
		
		System.out.println("请输入要添加的班级名");
		String clsName = sc.next();
		
		System.out.println("请输入要添加的班级描述");
		String desc = sc.next();
		
		//创建一个新对象
		Classes newCls = new Classes(clsId,clsName,desc);
		cls[index] = newCls;
		index++;
		System.out.println("添加班级成功.");
		
	}
	/**
	 * 删除班级(级联)
	 */
	public void deleteClasses(){
		System.out.println("请输入要删除的班级id");
		int clsId = sc.nextInt();
		
		Classes c = Tools.getClssesByClsId(clsId);
		if(c==null){
			System.out.println("要删除的班级id不存在");
			return;
		}
		
		//判断该班级底下是否有学生  
		Student[] s = Tools.getStudentByClsId(clsId);
		if(s.length!=0){
			//将该班级id下的所有学生删除		
			 StudentManager.deleteStudent(clsId);
			
		}else{//直接删除这个班级
			//创建一个新数组用来存储删除后的班级
			Classes[] newCls = new Classes[10];
			int newIndex = 0;
			for(int i=0;i<index;i++){
				if(cls[i].getClsId()!=clsId){
					newCls[newIndex] = cls[i];
					newIndex++;
				}
			}
			cls = newCls;
			index--;
			System.out.println("删除班级成功.");
		}
	}
	/**
	 * 修改班级信息(级联)
	 */
	public void updataClasses(){
		System.out.println("请输入要修改的班级id");
		int clsId = sc.nextInt();
		
		Classes c = Tools.getClssesByClsId(clsId);
		if(c==null){
			System.out.println("要修改的班级id不存在");
			return;
		}
		
		System.out.println("请输入修改后的班级id");
		int newId = sc.nextInt();
		
		Classes newC = Tools.getClssesByClsId(newId);
		if(newC!=null){
			System.out.println("该班级id已存在");
			return;
		}
		

		//判断该班级底下是否有学生
		Student[] s =  Tools.getStudentByClsId(clsId);
		if(s.length!=0){
			for(Student i:s){
				i.setClsId(newId);
			}
		}
		
		System.out.println("请输入修改后的班级名");
		String newName = sc.next();
		 
		System.out.println("请输入修改后的班级描述");
		String newDesc = sc.next();
		
			
		c.setClsId(newId);
		c.setClsName(newName);
		c.setDesc(newDesc);
		
		System.out.println("修改成功.");
	}
	/**
	 * 查看班级信息
	 */
	public void classesList(){
		if(index==0){
			System.out.println("还没有任何班级信息");
			return;
		}
		
		for(int i=0;i<index;i++){
			System.out.println(cls[i]);
		}
	}
}
