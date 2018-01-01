package day170320;

/**
 * 班级实体类
 * 
 * @author Administrator
 *
 */
public class Classes {

	private int classId; // 班级id
	private String name; // 班级名字
	private String desc; // 班级描述
	
	public Classes(){
		
	}
		
	public Classes(int classId, String name, String desc) {
		super();
		this.classId = classId;
		this.name = name;
		this.desc = desc;
	}
	
	
	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
	
}
