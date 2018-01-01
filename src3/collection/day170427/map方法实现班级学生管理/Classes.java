package collection.day170427.map方法实现班级学生管理;

public class Classes {
	private int clsId;
	private String clsName;
	private String desc;
	
	public Classes(){
		
	}

	public Classes(int clsId, String clsName, String desc) {
		this.clsId = clsId;
		this.clsName = clsName;
		this.desc = desc;
	}

	public int getClsId() {
		return clsId;
	}

	public void setClsId(int clsId) {
		this.clsId = clsId;
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
		return "Classes [clsId=" + clsId + ", clsName=" + clsName + ", desc=" + desc + "]";
	}
	
	
}
