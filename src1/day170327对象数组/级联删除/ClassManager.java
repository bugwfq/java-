package day170327对象数组.级联删除;

import java.util.Scanner;

/**
 * 班级管理类
 * 
 * @author Administrator
 *
 */
public class ClassManager {

	public static Classes[] cs = new Classes[10];
	public static int index;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 增加班级
	 */
	public void addClasses(){
		
		System.out.println("请输入班级id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c != null){
			System.out.println("你添加的班级id已存在.");
			return ;
		}
		
		System.out.println("请输入班级名称:");
		String cName = sc.next();
		
		System.out.println("请输入班级描述:");
		String cDesc = sc.next();
		
		// 创建一个新的对象
		Classes newC = new Classes(cid, cName, cDesc);
		cs[index] = newC;
		index ++;
		System.out.println("新增成功.");
	}
	
	/**
	 * 删除班级(级联)
	 */
	public void deleteClasses(){
		
		System.out.println("请输入你要删除的班级id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("你要删除的班级id不存在.");
			return ;
		}
		
		// 该班级底下是否有学生
		Student[] s = Tools.getStudentsByClassId(cid);
		if(s.length != 0){// 说明有学生，需要删除学生信息
			StudentManager stuManager = new StudentManager();
			stuManager.deleteBatch(s); // 将学生信息删除
		}
		
		Classes[] temp = new Classes[cs.length];
		int tempIndex = 0;
		for(int i = 0;i<index;i++){
			if(cs[i].getClassId() != cid){
				temp[tempIndex] = cs[i];
				tempIndex ++;
			}
		}
		
		cs = temp;
		index --;
		System.out.println("删除成功.");
	}
	
	/**
	 * 修改班级信息(级联)
	 */
	public void updateClasses(){
		System.out.println("请输入你要修改的班级id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("你要修改的班级id不存在.");
			return ;
		}
		
		System.out.println("请输入新的班级id:");
		int newCid = sc.nextInt();
		Classes newC = Tools.getClassesByCid(newCid);
		if(newC != null){
			System.out.println("新的班级id已存在.");
			return ;
		}
		
		// 判断该班级底下是否有学生
		Student[] s = Tools.getStudentsByClassId(cid);
		if(s.length != 0){
			for(Student ss:s){
				ss.setClassId(newCid);//将该班级下的所有学生班级改成修改后的班级
			}
		}
		
		c.setClassId(newCid);
		System.out.println("修改成功.");
	}
	
	/**
	 * 查询单个班级信息
	 */
	public void querySingleClasses(){
		
		System.out.println("请输入你要查询的班级id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("你要查询的班级id不存在.");
			return ;
		}
		System.out.println("班级信息如："+c);
	}
	
	/**
	 * 查询所有班级信息
	 */
	public void classesList(){
		
		if(index == 0){
			System.out.println("当前没有任何班级信息");
			return ;
		}
		System.out.println("所有班级信息如下:");
		for(int i = 0;i<index;i++){ // i<cs.length;
			System.out.println(cs[i]);
		}
	}
}
