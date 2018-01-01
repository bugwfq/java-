package day170406��������.work;

import java.util.Scanner;

public class UserManager {
	private Node head;//ͷ�ڵ�
	private Node tail;//β�ڵ�
	private int size;//����
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * �����û��ڵ�
	 */
	public void addUser(){
		System.out.println("������Ҫ���ӵ��û�id��");
		String id = sc.next();	
		
		if(getNodeByUserId(id)!=null){
			System.out.println("���û��Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ���ӵ��û�����");
		String name = sc.next();		
		
		System.out.println("������Ҫ���ӵ��û����룺");
		String password = sc.next();
		
		User user = new User(id,name,password);
		//����һ���½ڵ�
		Node newNode = new Node(user);
		
		//������һ���ڵ�
		if(head==null){
			head = newNode;//ͷ�ڵ��������Ľڵ�
			tail = newNode;//β�ڵ��������Ľڵ�
		}else{
			tail.setNext(newNode);//��β�ڵ�ָ���µĽڵ�
			tail = newNode;//��β�ڵ������½ڵ�
		}
		size++;
		System.out.println("���ӳɹ���");
	}
	
	/**
	 * ɾ���û��ڵ�
	 */
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id:");
		String id = sc.next();
		//ͨ���û�id��ȡ�û��ڵ�
		Node node = getNodeByUserId(id);
		if(node==null){
			System.out.println("Ҫɾ�����û�������");
			return;
		}
		
		Node beforeNode = getBeforeNodeByUserId(id);
		if(head.getUser().getUserId().equals(id) && tail.getUser().getUserId().equals(id)){//���ɾ���������һ���ڵ�
			head = null;
			tail = null;
		}else if(head.getUser().getUserId().equals(id)){//���ɾ������ͷ�ڵ�
			//��ȡͷ�ڵ����һ���ڵ�
			Node next = head.getNext();
			//��ͷ�ڵ�����һ���ƶ�
			head = next;
		}else if(node==tail){//���ɾ������β�ڵ�
			tail = beforeNode;
			beforeNode.setNext(null);
		}else{//���ɾ�������м�ڵ�
			node = node.getNext();
			beforeNode.setNext(node);
		}
		size--;
		System.out.println("ɾ���û��ɹ���");
	}
	
	private Node getNodeByUserId(String id){//ͨ���û�id��ȡ�û��ڵ�
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getUserId().equals(id)){
				return temp;
			}	
			temp = temp.getNext(); 
		}
		return temp;
	}
	private Node getBeforeNodeByUserId(String id){//ͨ���û�id��ȡǰһ���ڵ�
		Node temp = head;
		Node node = null;
		while(temp!=null){
			if(temp.getUser().getUserId().equals(id)){
				return node;
			}
			node = temp;
			temp = temp.getNext();
		}
		return null;
	}
	/**
	 * �޸��û��ڵ�
	 */
	public void updateUser(){
		System.out.println("������Ҫ�޸ĵ��û�id:");
		String id = sc.next();
		
		Node node = getNodeByUserId(id);
		if(node==null){
			System.out.println("û��Ҫ�޸ĵ��û�");
			return;
		}
		
		System.out.println("������Ҫ�޸ĵ��û�����");
		String name = sc.next();
		
		System.out.println("������Ҫ�޸ĵ��û����룺");
		String password = sc.next();
		
		User user = new User(id,name,password);
		node.setUser(user);
		System.out.println("�޸ĳɹ���");
	}
	/**
	 * �鿴�����û��ڵ�
	 */
	public void iterNode(){
		System.out.println("������Ҫ�鿴���û�id:");
		String id = sc.next();
		
		Node node = getNodeByUserId(id);
		if(node==null){
			System.out.println("Ҫ�鿴���û��ڵ㲻����");
		}else{
			System.out.println(node.getUser());
		}	
	}
	/**
	 * �鿴�����û��ڵ�(iterate)
	 */
	public void iterAllNode(){
		Node temp = head;
		if(temp==null){
			System.out.println("û��Ҫ�鿴���û��ڵ�");
			return;
		}
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getNext();
		}
	}
}
