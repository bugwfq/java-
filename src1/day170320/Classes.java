package day170320;

/**
 * �༶ʵ����
 * 
 * @author Administrator
 *
 */
public class Classes {

	private int classId; // �༶id
	private String name; // �༶����
	private String desc; // �༶����
	
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
