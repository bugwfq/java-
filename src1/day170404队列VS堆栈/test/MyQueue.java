package day170404����VS��ջ.test;

import java.util.Scanner;

public class MyQueue {
	private String[] elements = new String[10];
	private int index = 0;
	private int length = 0;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * ���
	 */
	public void addElement(){
		System.out.println("������Ҫ��ӵ�Ԫ�أ�");
		String data = sc.next();
		//ʵ�ֶ�̬����
		if(index == elements.length){
			String[] temp = new String[elements.length*2];
			for(int i=0;i<elements.length;i++){
				temp[i] = elements[i];
			}
		}
		elements[index] = data;
		index++;
		length++;
		System.out.println("��ӳɹ���");
	}
	 /**
	  * ����
	  */
	public void deleteElement(){
		if(length == 0){
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		System.out.println("��ǰ���ӵ�Ԫ���ǣ�"+elements[0]);
		//������Ԫ�ظ��Ƶ�������
		String[] temp = new String[elements.length-1];
		int tempIndex = 0;
		for(int i=1;i<index;i++){
			temp[tempIndex] = elements[i]; 
			tempIndex++;
		}
		elements = temp;
		index--;
		length--;
	}
	/**
	 * �鿴����Ԫ��
	 */
	public void querySingleElements(){
		if(length == 0){
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		System.out.println("������Ҫ�鿴�Ķ���Ԫ�أ�");
		String data = sc.next();
		boolean bool = false;
		for(int i=0;i<elements.length;i++){
			if(elements[i].equals(data)){
				bool = true;
				break;
			}
		}	
		if(bool==true){
			System.out.println("����Ԫ���ǣ�"+data);
		}else{
			System.out.println("û�ҵ�Ҫ�鿴�Ķ���Ԫ��");
		}
	}
	/**
	 * �鿴����
	 */
	public void length(){
		System.out.println("��ǰ���г����ǣ�"+length);
	}
	/**
	 * �鿴��������Ԫ��
	 */
	public void elementsList(){
		if(length==0){
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(elements[i]+"->");
		}
		System.out.println("Ҫ�鿴�Ķ���Ԫ���ǣ�"+builder.substring(0, builder.length()-2));
	}
}
