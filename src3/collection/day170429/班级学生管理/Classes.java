package collection.day170429.班级学生管理;

public class Classes {
	private String id; 
	private String clsName;
	private String desc;
	
	public Classes(){
		
	}

	public Classes(String id, String clsName, String desc) {
		this.id = id;
		this.clsName = clsName;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", clsName=" + clsName + ", desc=" + desc + "]";
	}
	
	
}
