package day170320;

import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ClassManager csmana = new ClassManager();
		StudentManager stumana = new StudentManager();
		boolean flag1 = true;
		while(flag1){	
			System.out.println("--------欢迎使用易通学生管理系统--------");
			System.out.println("1.班级管理2.学生管理0.退出系统");
			System.out.println("请选择：");
			int mark = input.nextInt();
			if(mark==1){//1.班级管理
				boolean flag2 = true;
				while(flag2){
					System.out.println("1.增加班级2.删除班级3.修改班级信息4.查询单个班级信息5.查询所有班级信息0.返回上一级");
					System.out.println("请选择：");
					int temp1 = input.nextInt();
					if(temp1==1){//1.增加班级
						csmana.addClasses();
					}else if(temp1==2){//2.删除班级
						csmana.deleteClasses();
					}else if(temp1==3){//3.修改班级信息
						csmana.updateClasses();
					}else if(temp1==4){//4.查询单个班级信息
						csmana.querySingleClasses();
					}else if(temp1==5){//5.查询所有班级信息
						csmana.classesList();
					}else{//0.退出系统
						flag2 = false;
					}
				}
			}else if(mark==2){//2.学生管理
				boolean flag3 = true;
				while(flag3){
					System.out.println("1.增加学生2.删除学生3.查询学生4.查询所有学生信息5.修改学生信息6.查询某个班里面的学生信息7.查询某个班级底下最大年龄的学生和最小年龄的学生8.查询某个班级底下男女生人数0.返回上一级");
					System.out.println("请选择：");
					int temp2 = input.nextInt();
					if(temp2==1){//1.增加学生
						stumana.addStudent();
					}else if(temp2==2){//2.删除学生
						stumana.deleteStudent();
					}else if(temp2==3){//3.查询学生
						stumana.querySingleStudent();
					}else if(temp2==4){//4.查询所有学生信息
						stumana.queryAllStudent();
					}else if(temp2==5){//5.修改学生信息
						stumana.updateStudent();
					}else if(temp2==6){//6.查询某个班里面的学生信息
						System.out.println("请输入要查询的班级id:");
						int cid = input.nextInt();
						Classes c = Tools.getClassesByCid(cid);
						stumana.queryStudentByClassId(c.getClassId());
					}else if(temp2==7){//7.查询某个班级底下最大年龄的学生和最小年龄的学生
						System.out.println("请输入要查询的班级id:");
						int cid = input.nextInt();
						Classes c = Tools.getClassesByCid(cid);
						stumana.queryMaxAgeVsMinAgeByClassId(c.getClassId());
					}else if(temp2==8){//8.查询某个班级底下男女生人数
						System.out.println("请输入要查询的班级id:");
						int cid = input.nextInt();
						Classes c = Tools.getClassesByCid(cid);
						stumana.queryBoysAndGirlsByClassId(c.getClassId());
					}else{//0.返回上一级
						flag3 = false;
					}
				}
			}else{//0.退出系统
				System.exit(0);
			}
		}
	}
}
