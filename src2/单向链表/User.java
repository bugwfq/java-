package ��������;
/**
 * �û��Ļ������ԣ��������Ե�set��get�����͹��췽��
 * @author Administrator
 *
 */
public class User {
	private String id;//�û�id
	private String name;//�û���
	private String age;//�û�����
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
	public String toString() {//��д����String����
		return " �û�id "+id+" �û�����"+ name + ", ���䣺" + age ;
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
