package day170327��������.��������ת��ά;

public class Test {
	public static void main(String[] args){
		//�ֱ��½���ά����Ͷ�������,������ͬ
		String[][] arr = new String[10][2];
		User[] user = new User[10];
		//��������ת��ά����
		for(int i=0;i<arr.length;i++){
			arr[i][0] = user[i].getName();
			arr[i][1] = user[i].getId();
		}
		
		//��ά����ת��������
		for(int i=0;i<user.length;i++){
			user[i].setName(arr[i][0]);
			user[i].setId(arr[i][1]);
		}
	}
}
