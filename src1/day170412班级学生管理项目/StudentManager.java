package day170412�༶ѧ��������Ŀ;

import java.util.Scanner;

public class StudentManager {

	// ѧ������
	private int length;
	private Scanner sc = new Scanner(System.in);
	
	
	
	public void deleteStudent(){
		System.out.println("������༶id");
		int cId = sc.nextInt();
		
		ClassesNode cNode = ClassesTools.getClassesNodeByCId(cId);
		if(cNode == null){
			System.out.println("�༶id������.");
			return;
		}
		
		System.out.println("������ѧ��id");
		int id = sc.nextInt();
		
		StudentNode sNode = StudentTools.getSNodeByCNodeAndStuId(cNode,id);
		if(sNode == null){
			System.out.println("��ѧ��id������.");
			return ;
		}
		
		// �ȵõ��ð༶���µ�ѧ������ͷ��β��
		StudentNode head = cNode.getDown();
		StudentNode tail = StudentTools.getLastStudentByCNode(cNode);
		
		if(head == sNode && tail == sNode){
			
			// �жϰ༶��ѧ����ָ��
			cNode.setDown(null);
			
		}else if(head == sNode){
			
			// �Ȼ�ȡͷ�ڵ����һ���ڵ�
			StudentNode nextNode = head.getAfter();
			
			// ���༶ָ��ѧ����ָ���޸�Ϊָ����һ���ڵ�
			cNode.setDown(nextNode);
			
			// ����һ���ڵ��ǰָ��ָ��null��������ѧ�������ͷ�ڵ㣩
			nextNode.setBefore(null);
			
		}else if(tail == sNode){
			
			// ��ȡβ�ڵ��ǰһ���ڵ�
			StudentNode beforeNode = tail.getBefore();
			
			// ��ǰһ���ڵ��ָ��ָ��null
			beforeNode.setAfter(null);
		}else{
			
			StudentNode beforeNode = sNode.getBefore();
			StudentNode afterNode = sNode.getAfter();
			
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
		
		length --;
		System.out.println("ɾ���ɹ�.");
		
	}
	
	public void addStudent(){
		
		System.out.println("������༶id");
		int cId = sc.nextInt();
		
		ClassesNode cNode = ClassesTools.getClassesNodeByCId(cId);
		if(cNode == null){
			System.out.println("�༶id������.");
			return;
		}
		
		System.out.println("������ѧ��id");
		int id = sc.nextInt();
		
		StudentNode sNode = StudentTools.getSNodeByCNodeAndStuId(cNode,id);
		if(sNode != null){
			System.out.println("��ѧ��id�Ѵ���.");
			return ;
		}
		
		System.out.println("������ѧ������");
		String name = sc.next();
		
		System.out.println("������ѧ������");
		int age = sc.nextInt();
		
		System.out.println("������ѧ���Ա�");
		String sex = sc.next();
		
		// ����ѧ������ѧ���ڵ�
		Student student = new Student(cId, id, name, sex, age);
		StudentNode newNode = new StudentNode(student);
		
		// �ð༶����û���κ�ѧ��
		if(cNode.getDown() == null){
			cNode.setDown(newNode); // �ð༶���µĵ�һ���ڵ㣨�ð༶ѧ�������ͷ�ڵ㣩
		}else{  // ��ӵ��ð༶�������һ��ѧ������
			
			// ��ȡ�ð༶�������һ��ѧ��
			StudentNode lastSNode = StudentTools.getLastStudentByCNode(cNode);
			
			lastSNode.setAfter(newNode);
			newNode.setBefore(lastSNode);
		}
		
		length ++;
		System.out.println("ѧ�����ӳɹ�.");
		
	}
}
