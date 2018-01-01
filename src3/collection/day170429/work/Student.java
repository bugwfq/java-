package collection.day170429.work;

public class Student {

	private String id;
	private String cName;
	private String name;
	private String age;
	private String sex;
	
	public Student(){}

	public Student(String id, String cName, String name, String age, String sex) {
		this.id = id;
		this.cName = cName;
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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
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
		return "Student [id=" + id + ", cName=" + cName + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
