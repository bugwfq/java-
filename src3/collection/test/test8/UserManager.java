package collection.test.test8;

import java.util.Scanner;

public class UserManager {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ����û�
	 */
	
	public void addUser(){
		System.out.println("������Ҫ��ӵ��û�id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp!=null){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = sc.next();
		
		User user = new User(id,name,password);
		Node newNode = new Node(user);
		
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{//��ӵ�β��
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
		System.out.println("��ӳɹ�");
	}
	
	/**
	 * ͨ���û�id��ȡ�û��ڵ�
	 */
	
	private Node getNodeById(int id){
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getId()==id){
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	/**
	 * ɾ���û�
	 */
	
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("���û�id������");
			return;
		}
		
		Node beforeNode = getBeforeNodeById(id);
		
		if(head.equals(temp) && tail.equals(temp)){//���һ���ڵ�
			head = null;
			tail = null;
		}else if(head.equals(temp)){//ͷ�ڵ�
			head = head.getNext();			
		}else if(tail.equals(temp)){//β�ڵ�
			tail = beforeNode;
			tail.setNext(null);
		}else{//�м�ڵ�
			Node next = temp.getNext();
			beforeNode.setNext(next);
		}
		size--;
		System.out.println("ɾ���ɹ�");
	
	}
	
	/**
	 * ͨ���û�id��ȡǰһ���ڵ�
	 */
	
	private Node getBeforeNodeById(int id){
		Node temp = head;
		Node node = null;
		while(temp!=null){
			if(temp.getUser().getId()==id){
				return node;
			}
			
			node = temp;
			temp = temp.getNext();
		}
		return null;
	}
	
	/**
	 * �޸��û�
	 */
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String name = sc.next();
		
		System.out.println("�������µ��û�����");
		String password = sc.next();
		
		temp.getUser().setUsername(name);
		temp.getUser().setPassword(password);
		System.out.println("�޸ĳɹ�");
	}
	
	
	/**
	 * �鿴�����û���Ϣ
	 */
	
	public void querySingleUser(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("���û���Ϣ���£�");
		System.out.println(temp.getUser());
	}
	
	/**
	 * �鿴�����û���Ϣ
	 */
	public void userList(){
		if(size==0){
			System.out.println("��ʱû���κ��û���Ϣ");
			return;
		}
		
		System.out.println("�����û���Ϣ���£�");
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getNext();
		}
	}
	
}
