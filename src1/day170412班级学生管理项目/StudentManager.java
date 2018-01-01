package day170412班级学生管理项目;

import java.util.Scanner;

public class StudentManager {

	// 学生数量
	private int length;
	private Scanner sc = new Scanner(System.in);
	
	
	
	public void deleteStudent(){
		System.out.println("请输入班级id");
		int cId = sc.nextInt();
		
		ClassesNode cNode = ClassesTools.getClassesNodeByCId(cId);
		if(cNode == null){
			System.out.println("班级id不存在.");
			return;
		}
		
		System.out.println("请输入学生id");
		int id = sc.nextInt();
		
		StudentNode sNode = StudentTools.getSNodeByCNodeAndStuId(cNode,id);
		if(sNode == null){
			System.out.println("该学生id不存在.");
			return ;
		}
		
		// 先得到该班级底下的学生链表（头和尾）
		StudentNode head = cNode.getDown();
		StudentNode tail = StudentTools.getLastStudentByCNode(cNode);
		
		if(head == sNode && tail == sNode){
			
			// 切断班级与学生的指针
			cNode.setDown(null);
			
		}else if(head == sNode){
			
			// 先获取头节点的下一个节点
			StudentNode nextNode = head.getAfter();
			
			// 将班级指向学生的指向修改为指向下一个节点
			cNode.setDown(nextNode);
			
			// 将下一个节点的前指针指向null（它就是学生链表的头节点）
			nextNode.setBefore(null);
			
		}else if(tail == sNode){
			
			// 获取尾节点的前一个节点
			StudentNode beforeNode = tail.getBefore();
			
			// 将前一个节点的指针指向null
			beforeNode.setAfter(null);
		}else{
			
			StudentNode beforeNode = sNode.getBefore();
			StudentNode afterNode = sNode.getAfter();
			
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
		
		length --;
		System.out.println("删除成功.");
		
	}
	
	public void addStudent(){
		
		System.out.println("请输入班级id");
		int cId = sc.nextInt();
		
		ClassesNode cNode = ClassesTools.getClassesNodeByCId(cId);
		if(cNode == null){
			System.out.println("班级id不存在.");
			return;
		}
		
		System.out.println("请输入学生id");
		int id = sc.nextInt();
		
		StudentNode sNode = StudentTools.getSNodeByCNodeAndStuId(cNode,id);
		if(sNode != null){
			System.out.println("该学生id已存在.");
			return ;
		}
		
		System.out.println("请输入学生姓名");
		String name = sc.next();
		
		System.out.println("请输入学生年龄");
		int age = sc.nextInt();
		
		System.out.println("请输入学生性别");
		String sex = sc.next();
		
		// 创建学生对象，学生节点
		Student student = new Student(cId, id, name, sex, age);
		StudentNode newNode = new StudentNode(student);
		
		// 该班级底下没有任何学生
		if(cNode.getDown() == null){
			cNode.setDown(newNode); // 该班级底下的第一个节点（该班级学生链表的头节点）
		}else{  // 添加到该班级底下最后一个学生后面
			
			// 获取该班级底下最后一个学生
			StudentNode lastSNode = StudentTools.getLastStudentByCNode(cNode);
			
			lastSNode.setAfter(newNode);
			newNode.setBefore(lastSNode);
		}
		
		length ++;
		System.out.println("学生增加成功.");
		
	}
}
