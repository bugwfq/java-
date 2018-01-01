package day170412班级学生管理项目;

import java.util.Scanner;

public class ClassesMananger {

	private int length;
	public static ClassesNode head;
	private ClassesNode tail;
	private Scanner sc = new Scanner(System.in);
	
	public void addClasses(){
		System.out.println("请输入班级id");
		int id = sc.nextInt();
		
		ClassesNode node = ClassesTools.getClassesNodeByCId(id);
		if(node != null){
			System.out.println("该班级id已存在.");
			return ;
		}
		
		System.out.println("请输入班级名称");
		String name = sc.next();
		
		System.out.println("请输入班级描述");
		String desc = sc.next();
		
		Classes c = new Classes(id, name, desc);
		ClassesNode newNode = new ClassesNode(c);
		
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.setAfter(newNode);
			newNode.setBefore(tail);
		}
		
		length ++;
		System.out.println("班级增加成功.");
		
	}
	
	public void classesList(){
		ClassesNode temp = head;
		while(temp != null){
			System.out.println(temp.getClasses());
			temp = temp.getAfter();
		}
	}
	
	/**
	 * 因为是链表结构（在删除班级时，那条链会跟着删除，所以不会存在级联删除)
	 */
	public void deleteClasses(){
		System.out.println("请输入你要删除的班级id");
		int id = sc.nextInt();
		
		ClassesNode node = ClassesTools.getClassesNodeByCId(id);
		if(node == null){
			System.out.println("该班级不存在.");
			return ;
		}
		
		if(head == node && tail == node){
			head = null;
			tail = null;
		}else if(head == node){
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail == node){
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{
			ClassesNode beforeNode = node.getBefore();
			ClassesNode afterNode = node.getAfter();
			
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
		
		length --;
		System.out.println("班级删除成功.");
	}
	
	/**
	 * 修改班级
	 */
	
	public void updateClasses(){
		System.out.println("请输入你要修改的班级id");
		int id = sc.nextInt();
		
		ClassesNode node = ClassesTools.getClassesNodeByCId(id);
		if(node == null){
			System.out.println("该班级不存在.");
			return ;
		}
	}
}
