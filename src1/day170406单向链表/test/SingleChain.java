package day170406��������.test;

import java.util.Scanner;

public class SingleChain {
	private Node head;//ͷ�ڵ�
	private Node tail;//β�ڵ�
	private int size = 0;//����
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ���ӽڵ�
	 */
	public void addNode(){
		System.out.println("������ڵ����ݣ�");
		String data = sc.next();
		
		//����һ���µĽڵ�
		Node newNode = new Node(data);
		//������һ���ڵ�
		if(head==null){
			head = newNode;//ͷ�ڵ��������Ľڵ�
			tail = newNode;//β�ڵ��������Ľڵ�
		}else{
			tail.setNext(newNode);//��β�ڵ�ָ���µĽڵ�
			tail = newNode;//��β�ڵ��ƶ�����һ���ڵ�
		}
		size++;
		System.out.println("�ڵ������ɹ���");
	}
	
	/**
	 * �����ڵ�
	 */
	public void iterNode(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
	
	/**
	 * ��ȡ�ڵ�
	 */
	
	private Node getNodeByData(String data){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return temp;
			}
			temp = temp.getNext();	
		}
		return null;
	}
	/**
	 * ��ȡǰһ���ڵ�
	 */
	private Node getBeforeNodeByData(String data){
		Node node = null;
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return node;
			}else{
				node = temp;
				temp = temp.getNext();
			}	
		}
		return null;
	}
	
	/**
	 * ɾ���ڵ�
	 */
	public void deleteNode(){
		System.out.println("������Ҫɾ���Ľڵ�");
		String data = sc.next();
		Node node = getNodeByData(data);//�Ȼ�ȡҪɾ���Ľڵ�
		if(node==null){
			System.out.println("Ҫɾ���Ľڵ㲻����");
			return;
		}
		
		if(head.getData().equals(data) && tail.getData().equals(data)){//���ɾ���������һ���ڵ�
			head = null;
			tail = null;
		}else if(head.getData().equals(data)){//���ɾ������ͷ�ڵ�
			//��ȡͷ�ڵ����һ���ڵ�
			Node next = head.getNext();
			//��ͷ�ڵ�����һ���ƶ�
			head = next;
		}else if(tail.getData().equals(data)){//���ɾ������β�ڵ�
			//�Ȼ�ȡβ�ڵ��ǰһ���ڵ�
			Node beforeNode = getBeforeNodeByData(data);
			beforeNode.setNext(null);//��ǰһ��ָ��ĺ�ڵ�ָ��null
			tail = beforeNode;//��β�ڵ��ƶ���ǰһ���ڵ㴦
		}else{//���ɾ�������м�ڵ�
			//��ȡǰһ���ڵ�
			Node beforeNode = getBeforeNodeByData(data);
			//��ȡ��һ���ڵ�
			Node afterNode = node.getNext();
			//�� ǰһ���ڵ�ĺ�ָ��ָ�����ĺ�һ���ڵ�
			beforeNode.setNext(afterNode);
		}
		size--;
		System.out.println("ɾ���ɹ���");
	}
}
