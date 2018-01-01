package demo1;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase db = Factory.CreatObj();
		db.saveData("学生信息");
	}
}
