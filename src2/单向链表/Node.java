package 单向链表;

public class Node {
	private User data;//用户信息
	private Node next;//指针
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
		return "节点用户： [" + data +"]";
	}
}
