package 单向链表;
/**
 * 用户的基本属性，及其属性的set，get方法和构造方法
 * @author Administrator
 *
 */
public class User {
	private String id;//用户id
	private String name;//用户名
	private String age;//用户年龄
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {//重写父类String方法
		return " 用户id "+id+" 用户名："+ name + ", 年龄：" + age ;
	}
	public User(){
		
	}
	public User(String id,String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
