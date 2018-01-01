package collection.day170517.test4;

import java.util.Scanner;

public class UserManager {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private Scanner sc = new Scanner(System.in); 
	
	/**
	 * ����û�
	 */
	public void add(){
		System.out.println("������Ҫ����û���id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node!=null){
			System.out.println("���û�id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û���");
		String name = sc.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = sc.next();
		
		User user = new User(id,name,password);
		Node newNode = new Node(user);
		
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
		
		size++;
		System.out.println("��ӳɹ�");
		
	}
	
	/**
	 * ͨ���û�id��ȡ�ڵ�
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
	public void delete(){
		System.out.println("������Ҫɾ���û���id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node==null){
			System.out.println("���û�id������");
			return;
		}
		
		Node beforeNode = getBeforeNodeById(id);
		if(head.equals(node) && tail.equals(node)){//���һ���ڵ�
			head = null;
			tail = null;
		}else if(head.equals(node)){//ͷ�ڵ�
			head = head.getNext();			
		}else if(tail.equals(node)){//β�ڵ�
			tail = beforeNode;
			tail.setNext(null);
		}else{//�м�ڵ�
			Node next = node.getNext();
			beforeNode.setNext(next);
		}
		
		size--;
		System.out.println("ɾ���ɹ�");
	}
	
	/**
	 * ͨ��id��ȡǰһ���ڵ�
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
	public void update(){
		System.out.println("������Ҫ�޸��û���id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println("�������µ��û���");
		String name = sc.next();
		
		System.out.println("�������µ��û�����");
		String password = sc.next();
		
		node.getUser().setUsername(name);
		node.getUser().setPassword(password);
		System.out.println("�޸ĳɹ�");
	}
	/**
	 * �鿴�����û�
	 */
	public void querySingle(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println(node.getUser());
	}
	/**
	 * �鿴�����û�
	 */
	public void list(){
		if(size==0){
			System.out.println("��ʱû���κ��û���Ϣ");
			return;
		}
		
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getNext();
		}
	}
}
