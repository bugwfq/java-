package day170407Ë«ÏòÁ´±í.test;

public class Node {
	private String data;
	private Node after;
	private Node before;
	
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
	public Node getAfter() {
		return after;
	}
	public void setAfter(Node after) {
		this.after = after;
	}
	public Node getBefore() {
		return before;
	}
	public void setBefore(Node before) {
		this.before = before;
	}
	
}
