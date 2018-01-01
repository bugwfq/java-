package collection.day170510;

public class Node {
	private String data;
	private Node before;
	private Node after;

	
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

	public Node getBefore() {
		return before;
	}

	public void setBefore(Node before) {
		this.before = before;
	}

	public Node getAfter() {
		return after;
	}

	public void setAfter(Node after) {
		this.after = after;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	
	
	
	
}
