package day170412班级学生管理项目;

import java.util.Scanner;

public class ReportManager {

	private Scanner sc = new Scanner(System.in);
	
	public void queryStudentsByCId(){
		
		System.out.println("请输入班级id");
		int cId = sc.nextInt();
		
		ClassesNode cNode = ClassesTools.getClassesNodeByCId(cId);
		if(cNode == null){
			System.out.println("该班级id不存在.");
			return ;
		}
		
		StudentNode temp = cNode.getDown();
		while(temp != null){
			System.out.println(temp.getStudent());
			temp = temp.getAfter();
		}
	}
}
