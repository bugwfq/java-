package 对象数组的增删改查级联;

import java.util.Scanner;

public class StudentManager {
	public static Student[] stu = new Student[10];
	public static int index = 0;
	public Scanner sc = new Scanner(System.in);
	/**
	 * 添加学生
	 */
	public void addStudent(){
		System.out.println("请输入要添加学生的班级id");
		int clsId = sc.nextInt();
		
		Classes c = Tools.getClssesByClsId(clsId);
		if(c!=null){
			System.out.println("该班级id已存在");
			return;
		}
		
		System.out.println("请输入要添加的学生id");
		int id = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(id);
		if(s!=null){
			System.out.println("要添加的学生id已存在");
			return;
		}
		
		System.out.println("请输入要添加的学生姓名");
		String stuName = sc.next();
		
		System.out.println("请输入要添加的学生年龄");
		int stuAge = sc.nextInt();
		
		System.out.println("请输入要添加的学生性别");
		String stuSex = sc.next();
		
		Student student = new Student(clsId,id,stuName,stuAge,stuSex);
		stu[index] = student;
		index++;
		System.out.println("添加学生成功.");
		
	}
	/**
	 * 删除学生
	 */
	public void deleteStudent(){
		System.out.println("请输入要删除的学生id");
		int id = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(id);
		if(s==null){
			System.out.println("要删除的学生id不存在");
			return;
		}
		
		//创建一个新的数组用来存放删除后的学生信息
		Student[] newStu = new Student[10];
		int newIndex = 0;
		for(int i=0;i<index;i++){
			if(stu[i].getId()!=id){
				newStu[newIndex] = stu[i];
				newIndex++;
			}
		}
		stu = newStu;
		index--;
		System.out.println("删除成功.");
		
	}
	
	/**
	 * 通过班级id删除学生
	 */
	public static void deleteStudent(int clsId){
		Classes cls = Tools.getClssesByClsId(clsId);
		if(cls==null){
			System.out.println("该班级id不存在");
			return;
		}
		
		//创建新数组用来存储删除后的学生信息
		Student[] newStu = new Student[10];
		int newIndex = 0;
		for(int i=0;i<index;i++){
			if(stu[i].getClsId()!=clsId){
				newStu[newIndex] = stu[i];
				newIndex++;
			}
		}
		stu = newStu;
		index--;
				
	}
	/**
	 * 修改学生信息
	 */
	public void updataStudent(){
		System.out.println("请输入要修改学生的id");
		int id = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(id);
		if(s==null){
			System.out.println("要修改的学生id不存在");
			return;
		}
		
		System.out.println("请输入要修改的学生姓名");
		String stuName = sc.next();
		
		System.out.println("请输入要修改的学生年龄");
		int stuAge = sc.nextInt();
		
		System.out.println("请输入要修改的学生性别");
		String stuSex = sc.next();
		
		s.setStuName(stuName);
		s.setStuAge(stuAge);
		s.setStuSex(stuSex);
		System.out.println("修改成功.");
		
	}
	/**
	 * 查看学生信息
	 */
	public void studentList(){
		if(index==0){
			System.out.println("还没有任何学生信息");
			return;
		}
		
		for(int i=0;i<index;i++){
			System.out.println(stu[i]);
		}
	}
}
