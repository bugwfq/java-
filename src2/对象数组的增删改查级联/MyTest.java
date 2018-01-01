package 对象数组的增删改查级联;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test 
	public void test(){
		Scanner sc = new Scanner(System.in);
		ClassesManager cm = new ClassesManager();
		StudentManager sm = new StudentManager();
		while(true){
			System.out.println("1.班级管理2.学生管理0.退出");
			int mark = sc.nextInt();
			if(mark==1){
				while(true){
					System.out.println("1.增加班级2.删除班级3.修改班级信息4.查看班级信息0.返回上一级");
					int mark1 = sc.nextInt();
					if(mark1==1){
						cm.addClasses();
					}else if(mark1==2){
						cm.deleteClasses();
					}else if(mark1==3){
						cm.updataClasses();
					}else if(mark1==4){
						cm.classesList();
					}else {
						break;
					}
				}
			}else if(mark==2){
				while(true){
					System.out.println("1.增加学生2.删除学生3.修改学生信息4.查看学生信息0.返回上一级");
					int mark2 = sc.nextInt();
					if(mark2==1){
						sm.addStudent();
					}else if(mark2==2){
						sm.deleteStudent();
					}else if(mark2==3){
						sm.updataStudent();
					}else if(mark2==4){
						sm.studentList();
					}else {
						break;
					}
				}
			}else{
				System.exit(0);
			}
		}
	}
}
