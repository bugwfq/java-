package collection.day170427.map方法实现班级学生管理;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {
	private Scanner sc = new Scanner(System.in);
	public static Map<Integer,Student> stuMap = new HashMap<>();
	
	/**
	 * 添加学生
	 */
	public void addStudent(){
		System.out.println("请输入要添加学生的班级id");
		int clsId = sc.nextInt();
		
		Classes cls = ClassesManager.clsMap.get(clsId);
		if(cls==null){
			System.out.println("要添加的学生班级id不存在");
			return;
		}
		
		System.out.println("请输入要添加的学生id");
		int stuId = sc.nextInt();
		
		boolean bools = stuMap.containsKey(stuId);
		if(bools==true){
			System.out.println("要添加的学生id已存在");
			return;
		}
		
		System.out.println("请输入要添加的学生姓名");
		String stuName = sc.next();
		
		System.out.println("请输入要添加的学生年龄");
		int stuAge = sc.nextInt();
		
		System.out.println("请输入要添加的学生性别");
		String stuSex = sc.next();
		
		Student stu = new Student(cls.getClsName(),stuId,stuName,stuAge,stuSex);
		stuMap.put(stuId, stu);
		System.out.println("添加学生成功！");
	}
	
	/**
	 * 删除学生
	 */
	public void deleteStudent(){
		System.out.println("请输入要删除的学生id");
		int stuId = sc.nextInt();
		
		boolean bool = stuMap.containsKey(stuId);
		if(bool==false){
			System.out.println("要删除的学生id不存在");
			return;
		}
		
		stuMap.remove(stuId);
		System.out.println("删除学生成功！");
		
	}
	
	/**
	 * 修改学生信息
	 */
	public void updateStudent(){
		System.out.println("请输入要修改的学生id");
		int stuId = sc.nextInt();
		
		boolean bool = stuMap.containsKey(stuId);
		if(bool==false){
			System.out.println("要修改的学生id不存在");
			return;
		}
		
		System.out.println("请输入要修改的学生姓名");
		String stuName = sc.next();
		
		System.out.println("请输入要修改的学生年龄");
		int stuAge = sc.nextInt();
		
		System.out.println("请输入要修改的学生性别");
		String stuSex = sc.next();
		
		stuMap.get(stuId).setStuName(stuName);
		stuMap.get(stuId).setStuAge(stuAge);
		stuMap.get(stuId).setStuSex(stuSex);
		System.out.println("修改成功！");
	}
	
	/**
	 * 查看单个学生信息
	 */
	public void querySingleStudent(){
		System.out.println("请输入要查看的学生id");
		int stuId = sc.nextInt();
		
		if(stuMap.containsKey(stuId)==false){
			System.out.println("没有该学生id");
			return;
		}
		
		System.out.println(stuMap.get(stuId));
	}
		
	/**
	 * 查看学生信息
	 */
	public void studentList(){
		if(stuMap.isEmpty()==true){
			System.out.println("没有任何学生信息");
			return;
		}
		
		Set<Integer> stuId = stuMap.keySet();
		Iterator<Integer> iter = stuId.iterator();
		while(iter.hasNext()){
			Integer id = iter.next();
			Student stu = stuMap.get(id);
			System.out.println(stu);
		}		
	}	
}
