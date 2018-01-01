package Instanceof;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = Tools.idVSname(new Teacher()/*new Student()*/);
		if(p instanceof Student){//判断接收的值是否是Student类型
			Student newstu = (Student)p;//如果是就将父类的p向下转型(强转)
			System.out.println(newstu);
		}else if(p instanceof Teacher){//判断接收的值是否是Teacher类型
			Teacher t = (Teacher)p;//如果是，就将父类的p向下转型（强转）
			System.out.println(t);
		}
	}

}
