package day170407˫������.test;

import java.util.Scanner;

public class DoubleChain {
	private Node head;
	private Node tail;
	private int size;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ���ӽڵ�
	 */
	public void addNode(){
		System.out.println("����������:");
		String data = sc.next();
		//����һ���½ڵ�
		Node newNode = new Node(data);
		//������һ���ڵ�
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{	
			//���½ڵ�ָ��β�ڵ�
			tail.setAfter(newNode);
			//��β�ڵ�ָ���½ڵ�
			newNode.setBefore(tail);
			//��β�ڵ��ƶ����½ڵ�
			tail = newNode;
		}
		size++;
		System.out.println("��ӳɹ���");
	}
	
	/**
	 *	left to right
	 */
	public void ltr(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getData());
			temp = temp.getAfter();
		}
	}
	
	/**
	 * right to left
	 */
	public void rtl(){
		Node temp = tail;
		while(temp!=null){
			System.out.println(temp.getData());
			temp = temp.getBefore();
		}
	}
	
	/**
	 * ɾ���ڵ�
	 */
	public void deleteElement(){
		System.out.println("������Ҫɾ�������ݣ�");
		String data = sc.next();
		Node node = getNodeByData(data);
		if(node==null){
			System.out.println("û��Ҫɾ��������");
			return;
		}
		if(head.getData().equals(data) && tail.getData().equals(data)){
			head = null;
			tail = null;
		}else if(head.getData().equals(data)){
			head = head.getAfter();
			//��ֹ��β�ڵ������ʱ���ֳ���ͷ�ڵ�
			head.setBefore(null);
		}else if(tail.getData().equals(data)){
			tail = tail.getBefore();
			//��ֹ��ͷ�ڵ������ʱ���ֳ���β�ڵ�
			tail.setAfter(null);
		}else{
			Node beforeNode = node.getBefore();
			Node afterNode = node.getAfter();
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
	}
	public Node getNodeByData(String data){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
}
