package day170404����VS��ջ.test;

import java.util.Scanner;

import day170324.User;

public class MyStack {
	private String[] s = new String[5];
	private int index = s.length-1;
	private int length = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ��ջ
	 */
	public void addElement(){
		System.out.println("������Ҫ��ջ��Ԫ��");
		String data = sc.next();
		
		//����
		if(index==0){
			String[] newS = new String[s.length*2];
			int tempIndex = newS.length-1;
			for(int i=s.length-1;i>index;i--){
				newS[tempIndex--] = s[i];
			}
			
			s = newS;
			index = tempIndex;
		}
		
		s[index] = data;
		index--;
		length++;
		System.out.println("��ջ�ɹ�");
		
	}
	/**
	 * ��ջ
	 */
	public void deleteElement(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
			return;
		}
		
		System.out.println("��ջ��Ԫ���ǣ�"+s[index+1]);
		
		//����һ�������������洢��ջ���Ԫ��
		String[] newS = new String[s.length];
		int tempIndex = s.length-1;
		for(int i=s.length-1;i>index+1;i--){
			newS[tempIndex--] = s[i];
		}
		s = newS;
		index = tempIndex;
		length--;
		System.out.println("��ջ�ɹ�");
	}
	/**
	 * �鿴ջ����
	 */
	public void length(){
		System.out.println("��ǰջ�����ǣ�"+length);
	}
	/**
	 * �鿴ջ��Ԫ��
	 */
	public void allElements(){
		if(length==0){
			System.out.println("��ǰջ��Ϊ��");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=s.length-1;i>index;i--){
			builder.append(s[i]+"->");
		}
		System.out.println(builder.substring(0, builder.length()-2));
	}
	
}
