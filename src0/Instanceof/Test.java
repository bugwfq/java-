package Instanceof;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = Tools.idVSname(new Teacher()/*new Student()*/);
		if(p instanceof Student){//�жϽ��յ�ֵ�Ƿ���Student����
			Student newstu = (Student)p;//����Ǿͽ������p����ת��(ǿת)
			System.out.println(newstu);
		}else if(p instanceof Teacher){//�жϽ��յ�ֵ�Ƿ���Teacher����
			Teacher t = (Teacher)p;//����ǣ��ͽ������p����ת�ͣ�ǿת��
			System.out.println(t);
		}
	}

}
