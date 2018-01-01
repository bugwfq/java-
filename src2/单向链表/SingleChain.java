package ��������;

import java.util.Scanner;
/**
 * �����ݵĲ���  ͨ��head��tail��������ɾ�Ĳ�
 * @author Administrator
 *
 */
public class SingleChain {
	private Node head;
	private Node tail;
	private int length;
	private Scanner input = new Scanner(System.in);
	/**
	 * ����id�ռ���Ϣȷ�� ��ͷ���β
	 */
	public void addNode(){//����½ڵ�
		System.out.println("������Ҫ��ӵ��û�id");
		String id = input.next();
		if(getNodeByid(id)!=null){
			System.out.println("���û��Ѵ��ڣ�");
			return;
		}
		System.out.println("�������û�������");
		String name = input.next();
		System.out.println("�������û����䣺");
		String age = input.next();
		Node temp = new Node(new User(id,name,age));
		if(head == null){
			head = temp;
			tail = temp;
		}else{
			tail.setNext(temp);
			tail=temp;
		}
		length ++;
		System.out.println("�ڵ���ӳɹ���");
	}
	/**
	 * ͨ��id���ظ��û��ڵ㲢�Ѹýڵ��ָ����ýڵ��ǰһ���ڵ��ָ���滻
	 */
	public void deleteNode(){//ɾ���ڵ�
		System.out.println("������Ҫɾ�����û�id");
		String id = input.next();
		Node temp=getNodeByid(id);
		Node tempBefor=getBeforNodeByNode(id);//ͨ��id����һ���ڵ�
		if(temp==null){
			System.out.println("û�и��û���");
			return;
		}
		if(temp==head && temp==tail){
			head=null;
			tail=null;
		}else if(temp==head){
			head=head.getNext();
		}else if(temp==tail){
			tempBefor.setNext(null);
			tail = tempBefor;
		}else{
			tempBefor.setNext(temp.getNext());
		}
		System.out.println("ɾ���ɹ���");
		length --;
	}
	/**
	 * ͨ��id����һ���ڵ��ṩ�޸�
	 */
	public void updateNode(){//�޸Ľڵ�
		System.out.println("������Ҫ�޸ĵ��û�id");
		String id = input.next();
		Node temp=getNodeByid(id);
		if(temp==null){
			System.out.println("û�и��û���");
			return;
		}
		System.out.println("��ѡ����Ҫ�޸ĵ����ݣ�\r\n1.�޸��û�������\r\n2.�޸��û����䣺\r\n0.ȫ���޸�");
		int menu=input.nextInt();
		if(menu==1 || menu==0){
			System.out.println("���������û�������");
			String name = input.next();


			temp.getData().setName(name);
		}
		if(menu==2 || menu==0){
			System.out.println("���������û����䣺");
			String age = input.next();
			temp.getData().setAge(age);
		}else{
			System.out.println("��������");
			return ;
		}
		System.out.println("�޸ĳɹ���");
	}
	/**
	 * ͨ��id��ʾ�����û��Ľڵ�
	 */
	public void iterNode(){//�鿴ָ��������Ϣ
		System.out.println("������Ҫ���ҵĵ��û�id");
		String id = input.next();
		Node temp=getNodeByid(id);
		if(temp!=null){
			System.out.println(temp);
		}else{
			System.out.println("û�и��û���");
		}
		
	}
	/**
	 * �鿴�������е�����
	 */
	public void iterNodeAll(){//�鿴����������Ϣ
		Node temp=head;
		if(length==0){
			System.out.println("û���û���Ϣ��");
			return;
		}
		while(temp!=null){
			System.out.println(temp);
			temp=temp.getNext();
		}
	}
	/**
	 * ���ݴ�������id���û������ڵ��ǰһ���ڵ�
	 * @param id
	 * @return
	 */
	public Node getBeforNodeByNode(String id){
		Node tempBefor = null;
		Node temp = head;
		while(temp!=null){
			if(temp.getData().getId().equals(id)){
				return tempBefor;
			}
			tempBefor=temp;
			temp=temp.getNext();
		}
		return null;
	}
	/**
	 * ���ݴ�������id���û������Ľڵ�
	 * @param id
	 * @return
	 */
	public Node getNodeByid(String id){//ͨ��id����һ���ڵ�
		Node temp = head;
		while(temp!=null){
			if(temp.getData().getId().equals(id)){
				return temp;
			}
			temp=temp.getNext();
		}
		return null;
	}
}
