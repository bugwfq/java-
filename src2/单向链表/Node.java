package ��������;

public class Node {
	private User data;//�û���Ϣ
	private Node next;//ָ��
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(){
		
	}
	public Node(User data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "�ڵ��û��� [" + data +"]";
	}
}
