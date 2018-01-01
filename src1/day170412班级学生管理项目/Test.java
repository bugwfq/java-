package day170412班级学生管理项目;

import java.util.Scanner;

public class Test {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		while(true){
			System.out.println("1.班级管理2.学生管理3.报表管理4.退出");
			int mark1 = sc.nextInt();
			
			if(mark1 == 1){
				classMenu();
			}else if(mark1 == 2){
				studentMenu();
			}else if(mark1 == 3){
				reportMenu();
			}else{
				System.exit(0);
			}
		}
	}
	
	public static void studentMenu(){
		
		StudentManager sm = new StudentManager();
		
		while(true){
			System.out.println("1.增加学生2.删除学生3.修改学生4.查看学生5.返回上一级");
			int mark1 = sc.nextInt();
			
			if(mark1 == 1){
				sm.addStudent();
			}else if(mark1 == 2){
				sm.deleteStudent();
			}else if(mark1 == 3){
			}else if(mark1 == 4){
			}else{
				break;
			}
		}
	}
	
	public static void reportMenu(){
		
		ReportManager rm = new ReportManager();
		while(true){
			System.out.println("1.查询某班级底下所有学生2.删除班级3.修改班级4.查看班级5.返回上一级");
			int mark1 = sc.nextInt();
			
			if(mark1 == 1){
				rm.queryStudentsByCId();
			}else if(mark1 == 2){
			}else if(mark1 == 3){
			}else if(mark1 == 4){
			}else{
				break;
			}
		}
	}
	
	public static void classMenu(){
		ClassesMananger cm = new ClassesMananger();
		
		while(true){
			System.out.println("1.增加班级2.删除班级3.修改班级4.查看班级5.返回上一级");
			int mark1 = sc.nextInt();
			
			if(mark1 == 1){
				cm.addClasses();
			}else if(mark1 == 2){
				cm.deleteClasses();
			}else if(mark1 == 3){
				cm.updateClasses();
			}else if(mark1 == 4){
				cm.classesList();
			}else{
				break;
			}
		}
	}
}
