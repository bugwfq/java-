package day170412�༶ѧ��������Ŀ;

import java.util.Scanner;

public class Test {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		while(true){
			System.out.println("1.�༶����2.ѧ������3.�������4.�˳�");
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
			System.out.println("1.����ѧ��2.ɾ��ѧ��3.�޸�ѧ��4.�鿴ѧ��5.������һ��");
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
			System.out.println("1.��ѯĳ�༶��������ѧ��2.ɾ���༶3.�޸İ༶4.�鿴�༶5.������һ��");
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
			System.out.println("1.���Ӱ༶2.ɾ���༶3.�޸İ༶4.�鿴�༶5.������һ��");
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
