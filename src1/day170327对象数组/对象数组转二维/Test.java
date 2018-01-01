package day170327对象数组.对象数组转二维;

public class Test {
	public static void main(String[] args){
		//分别新建二维数组和对象数组,长度相同
		String[][] arr = new String[10][2];
		User[] user = new User[10];
		//对象数组转二维数组
		for(int i=0;i<arr.length;i++){
			arr[i][0] = user[i].getName();
			arr[i][1] = user[i].getId();
		}
		
		//二维数组转对象数组
		for(int i=0;i<user.length;i++){
			user[i].setName(arr[i][0]);
			user[i].setId(arr[i][1]);
		}
	}
}
