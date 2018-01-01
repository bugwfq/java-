package day170412�༶ѧ��������Ŀ;

import java.util.Scanner;

public class ClassesMananger {

	private int length;
	public static ClassesNode head;
	private ClassesNode tail;
	private Scanner sc = new Scanner(System.in);
	
	public void addClasses(){
		System.out.println("������༶id");
		int id = sc.nextInt();
		
		ClassesNode node = ClassesTools.getClassesNodeByCId(id);
		if(node != null){
			System.out.println("�ð༶id�Ѵ���.");
			return ;
		}
		
		System.out.println("������༶����");
		String name = sc.next();
		
		System.out.println("������༶����");
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
		System.out.println("�༶���ӳɹ�.");
		
	}
	
	public void classesList(){
		ClassesNode temp = head;
		while(temp != null){
			System.out.println(temp.getClasses());
			temp = temp.getAfter();
		}
	}
	
	/**
	 * ��Ϊ������ṹ����ɾ���༶ʱ�������������ɾ�������Բ�����ڼ���ɾ��)
	 */
	public void deleteClasses(){
		System.out.println("��������Ҫɾ���İ༶id");
		int id = sc.nextInt();
		
		ClassesNode node = ClassesTools.getClassesNodeByCId(id);
		if(node == null){
			System.out.println("�ð༶������.");
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
		System.out.println("�༶ɾ���ɹ�.");
	}
	
	/**
	 * �޸İ༶
	 */
	
	public void updateClasses(){
		System.out.println("��������Ҫ�޸ĵİ༶id");
		int id = sc.nextInt();
		
		ClassesNode node = ClassesTools.getClassesNodeByCId(id);
		if(node == null){
			System.out.println("�ð༶������.");
			return ;
		}
	}
}
