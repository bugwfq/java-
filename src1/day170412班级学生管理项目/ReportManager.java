package day170412�༶ѧ��������Ŀ;

import java.util.Scanner;

public class ReportManager {

	private Scanner sc = new Scanner(System.in);
	
	public void queryStudentsByCId(){
		
		System.out.println("������༶id");
		int cId = sc.nextInt();
		
		ClassesNode cNode = ClassesTools.getClassesNodeByCId(cId);
		if(cNode == null){
			System.out.println("�ð༶id������.");
			return ;
		}
		
		StudentNode temp = cNode.getDown();
		while(temp != null){
			System.out.println(temp.getStudent());
			temp = temp.getAfter();
		}
	}
}
