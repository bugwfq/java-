package day170327��������.��дtostring����;

public class Test {
			// 1.== ���ԱȽϻ�������Ҳ���ԱȽ���������,equalsֻ�ܱȽ���������
			// 2.== ���ڻ��������ǱȽ����ǵ�ֵ,== �Ƚ����������ǱȽ����ǵ�"��ַ"
			// 3.equals�Ƚ�����Ĭ�ϵĹ���ͬ==һ�����Ƚ����ǵĵ�ַ��
			// 4.==�Ƚ��������ͣ���������������Ҫ�м̳й�ϵ,������벻��.
			// 5.equals�ȽϹ���ͬ==һ��������������Ҫ��дequals��ʵ���Զ���ȽϹ���
	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		
		//toString()����
		User user = new User("admin","admin");
		System.out.println(user);
		
		//clone()����
		User user1 = new User("admin","admin");
		User user2 = user1.clone();
		System.out.println(user1);
		System.out.println(user2);
		System.out.println("---------");
		user2.setName("simon");
		user2.setPassword("simon");
		System.out.println(user2);
		
		//equals()����
		User user3 = new User("admin","admin");
		System.out.println(user1==user3);//false>-��ַ��ͬ
		System.out.println(user1.equals(user3));//false>-��ַ��ͬ
		
		
		
	}
	
}
