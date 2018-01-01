package ˫������;



import java.util.Scanner;

public class UserManager {
	private Node head;//�����ͷ
	private Node tail;//�����β
	private int length;//����ĳ���
	private Scanner input = new Scanner(System.in);
	/**
	 * ����
	 */
	public void addUser(){//���
		System.out.println("������Ҫ��ӵ�id��");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node!=null){
			System.out.println("��id�Ѵ��ڣ�");
			return;
		}
		
		System.out.println("������Ҫ��ӵ��û�������");
		String name = input.next();
		
		System.out.println("������Ҫ��ӵ��û�����");
		String password = input.next();
		
		Node newNode = new Node(new User(id,name,password));
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			//��β�ڵ��afterָ�븳ֵ
			tail.setAfter(newNode);
			//���½ڵ��beforeָ�븳ֵ
			newNode.setBefore(tail);
			//��β��������
			tail=newNode;
		}
		
		length++;
		System.out.println("��ӳɹ���");
	}
	/**
	 * ɾ��
	 */
	public void deleteUser(){//ɾ��
		System.out.println("������Ҫɾ����id��");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node == null){
			System.out.println("û�и��û���");
			return;
		}
		
		if(node == head && node == tail){
			head = null;
			tail = null;
		}else if(node == head){
			head = node.getAfter();
			head.setBefore(null);
		}else if(node == tail){
			tail = node.getBefore();
			tail.setAfter(null);
		}else{
			Node before = node.getBefore();
			Node after = node.getAfter();
			before.setAfter(after);
			after.setBefore(before);
			
		}
		length --;
		System.out.println("ɾ���ɹ���");
	}
	/**
	 *�޸� 
	 */
	public void updateUser(){//�޸�
		System.out.println("������Ҫ�޸ĵ�id��");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node == null){
			System.out.println("û�и��û���");
			return;
		}
		
		System.out.println("��ѡ����Ҫ�޸ĵ����ݣ�\r\n1.�޸��û�������\r\n2.�޸��û����䣺\r\n0.ȫ���޸�");
		int menu=input.nextInt();
		
		if(menu==1 || menu==0){
			System.out.println("���������û�������");
			String name = input.next();
			node.getUser().setName(name);
		}
		
		if(menu==2 || menu==0){
			System.out.println("���������û����룺");
			String passWord = input.next();
			
			node.getUser().setPassWord(passWord);
		}else{
			System.out.println("��������");
			return ;
		}
		
		System.out.println("�޸ĳɹ���");
	}
	/**
	 * left to right
	 */
	public void ltr(){
		Node node = head;
		while(node != null){
			System.out.println(node.getUser());
			node = node.getAfter();
		}
	}
	/**
	 * right to left
	 */
	public void rtl(){
		Node node = tail;
		while(node != null){
			System.out.println(node.getUser());
			node = node.getBefore();
		}
	}
	/**
	 * ���ҵ����û�
	 */
	public void findUser(){
		System.out.println("������Ҫ���ҵ�id��");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node == null){
			System.out.println("û�и��û���");
			return;
		}
		
		System.out.println(node.getUser());
	}
	/**
	 * �����û�id����һ���ڵ�
	 * @param id
	 * @return
	 */
	public Node getNodeByUserId(String id){
		Node node=head;
		while(node != null){
			if(node.getUser().getId().equals(id)){
				return node;
			}
			node=node.getAfter();
		}
		return null;
	}
}
