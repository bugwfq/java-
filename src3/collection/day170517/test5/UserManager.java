package collection.day170517.test5;

import java.util.Scanner;

public class UserManager {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private Scanner sc = new Scanner(System.in);
	/**
	 * ���
	 */
	public void add(){
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
		}else{
			tail.setAfter(newNode);
			newNode.setBefore(tail);
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
			temp = temp.getAfter();
		}
		return null;
	}
	
	
	/**
	 * ɾ��
	 */
	public void delete(){
		System.out.println("������Ҫɾ�����û�id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("���û�id������");
			return;
		}
		
		if(head.equals(temp) && tail.equals(temp)){//���һ���ڵ�
			head = null;
			tail = null;
		}else if(head.equals(temp)){//ͷ�ڵ�
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail.equals(temp)){//β�ڵ�
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{//�м�ڵ�
			Node before = temp.getBefore();
			Node after = temp.getAfter();
			before.setAfter(after);
			after.setBefore(before);
		}
		size--;
		System.out.println("ɾ���ɹ�");
		
	}
	/**
	 * �޸�
	 */
	public void update(){
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
		
		temp.getUser().setName(name);
		temp.getUser().setPassword(password);
		System.out.println("�޸ĳɹ�");
	}
	/**
	 * �鿴����
	 */
	public void querySingle(){
		System.out.println("������Ҫ�鿴���û�id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("���û�id������");
			return;
		}
		
		System.out.println(temp.getUser());
	}
	/**
	 * �鿴����
	 */
	public void list(){
		if(size==0){
			System.out.println("��ʱû���κ��û���Ϣ");
			return;
		}
		
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getAfter();
		}
	}
	
}
