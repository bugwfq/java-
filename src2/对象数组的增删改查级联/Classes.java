package 对象数组的增删改查级联;

public class Classes {
	private int clsId;//班级id
	private String clsName;//班级名
	private String desc;//班级描述
	
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

