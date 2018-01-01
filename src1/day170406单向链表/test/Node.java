package day170406单向链表.test;

public class Node {
	private String data;//数据部分
	private Node next;//指针
	public Node(){
		
	}
	public Node(String data){
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
}
