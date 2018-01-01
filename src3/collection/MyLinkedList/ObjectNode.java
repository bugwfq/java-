package collection.MyLinkedList;

public class ObjectNode {
	private Object obj;
	private ObjectNode before;
	private ObjectNode after;
	
	public ObjectNode(){
		
	}
		
	public ObjectNode(Object obj) {
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public ObjectNode getBefore() {
		return before;
	}

	public void setBefore(ObjectNode before) {
		this.before = before;
	}

	public ObjectNode getAfter() {
		return after;
	}

	public void setAfter(ObjectNode after) {
		this.after = after;
	}


	
	
	
}
