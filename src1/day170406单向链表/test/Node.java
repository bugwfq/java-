package day170406��������.test;

public class Node {
	private String data;//���ݲ���
	private Node next;//ָ��
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
