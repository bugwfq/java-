package day170407˫������.work;

import java.util.Scanner;

public class UserManager {
	private Node head;//ͷ�ڵ�
	private Node tail;//β�ڵ�
	private int size = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ��ĳλ�ýڵ�ǰ���
	 */
	public void addBefore(){
		if(head==null){
			Node temp = getNewNode();
			head = temp;
			tail = temp;
			return;
		}
		
		System.out.println("������λ�ýڵ��id");
		String posId = sc.next();
		Node pos = getNodeByUserId(posId);
		if(pos==null){
			System.out.println("û�и�λ��");
			return;
		}
		//�����½ڵ�
		Node temp = getNewNode();
		if(temp==null){
			return;
		}
		if(head.getUser().getUserId().equals(posId)){
			head.setBefore(temp);
			temp.setAfter(head);
			head = temp;
		}else{
			Node before = pos.getBefore();
			temp.setBefore(before);
			temp.setAfter(pos);
			before.setAfter(temp);
			pos.setBefore(temp);			
		}	
		size++;
		System.out.println("���ӳɹ���");
	}
	private Node getNewNode() {
		System.out.println("������Ҫ��ӵ��û�id");
		String id = sc.next();
		Node newNode = getNodeByUserId(id);
		if(newNode!=null){
			System.out.println("���û�id�Ѵ���");
			return null;
		}
		System.out.println("�������û���");
		String name = sc.next();
		System.out.println("�������û�����");
		String password = sc.next();
		User user = new User(id,name,password);
		Node temp = new Node(user);
		return temp;
	}
	/**
	 * ��ĳλ�ýڵ�ĺ������
	 */
	public void addAfter(){
		if(head==null){
			Node temp = getNewNode();
			head = temp;
			tail = temp;
			return;
		}
		
		System.out.println("������λ�ýڵ��id");
		String posId = sc.next();
		Node pos = getNodeByUserId(posId);
		if(pos==null){
			System.out.println("û�и�λ��");
			return;
		}
		Node newNode = getNewNode();
		if(tail.getUser().getUserId().equals(posId)){
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = newNode;
		}else{
			Node after = pos.getAfter();
			newNode.setBefore(pos);
			newNode.setAfter(after);
			pos.setAfter(newNode);
			after.setBefore(newNode);
		}
		size++;
		System.out.println("���ӳɹ���");
	}
	
	
	/**
	 * �����û�
	 */
	public void addUser(){
		//����һ���½ڵ�
		Node newNode = getNewNode();
		if(newNode == null){
			return;
		}
		//������һ���ڵ�
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{
			//β�ڵ�ĺ�ָ��ָ���½ڵ�
			tail.setAfter(newNode);
			//���½ڵ��ǰָ��ָ��β�ڵ�
			newNode.setBefore(tail);
			//��β�ڵ��ƶ����½ڵ㴦
			tail = newNode;
		}
		size++;
		System.out.println("���ӳɹ���");
	}
	/**
	 * ɾ���û�
	 */
	public void deleteUser(){
		System.out.println("������Ҫɾ�����û�id:");
		String id = sc.next();
		
		Node temp = getNodeByUserId(id);
		if(temp==null){
			System.out.println("Ҫɾ�����û�id������");
			return;
		}
		
		if(head.getUser().getUserId().equals(id) && tail.getUser().getUserId().equals(id)){//ɾ�����һ���ڵ�
			head = null;
			tail = null;
		}else if(head.getUser().getUserId().equals(id)){//ɾ��ͷ�ڵ�
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail.getUser().getUserId().equals(id)){//ɾ��β�ڵ�
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{//ɾ���м�Ľڵ�
			Node beforeNode = temp.getBefore();
			Node afterNode = temp.getAfter();
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
		size--;
		System.out.println("ɾ���ɹ���");
	}
	
	/**
	 * ͨ���û�id��ȡ�û��ڵ�
	 */
	public Node getNodeByUserId(String id){
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getUserId().equals(id)){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
	/**
	 * �޸��û�
	 */
	public void updataUser(){
		System.out.println("������Ҫ�޸ĵ��û�id:");
		String id = sc.next();
		
		Node temp = getNodeByUserId(id);
		if(temp==null){
			System.out.println("Ҫ�޸��û���id������");
			return;
		}
		
		System.out.println("������Ҫ�޸ĵ��û�����");
		String name = sc.next();
		
		System.out.println("������Ҫ�޸ĵ��û����룺");
		String password = sc.next();
		
		temp.getUser().setUserName(name);
		temp.getUser().setPassword(password);
		System.out.println("�޸ĳɹ���");
	}
	/**
	 * �鿴�û����������ң�
	 */
	public void ltr(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getAfter();
		}
	}
	/**
	 * �鿴�û�����������
	 */
	public void rtl(){
		Node temp = tail;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getBefore();
		}
	}
	/**
	 * ��������
	 */
	public void iterSingleUser(){
		System.out.println("������Ҫ�鿴���û�id:");
		String id = sc.next();
		
		Node temp = getNodeByUserId(id);
		if(temp==null){
			System.out.println("Ҫ�鿴���û�id������");
		}else{
			System.out.println(temp.getUser());
		}	
	}
}
