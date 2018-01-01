package collection.day170429.班级学生管理;

public class Student {
	private String id;
	private String clsName;
	private String name;
	private String age;
	private String sex;
	
	public Student(){
		
	}

	public Student(String id, String clsName, String name, String age, String sex) {
		this.id = id;
		this.clsName = clsName;
		this.name = name;
		this.age = age;
		this.sex = sex;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", clsName=" + clsName + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
