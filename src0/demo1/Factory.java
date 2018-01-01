package demo1;

public class Factory {//创建Factory类
	public static DataBase CreatObj(){
		DataBase db =null;
		String dbname="大型数据库";
		if(dbname.equals("大型数据库"))
			db=new Oracle();
		else if(dbname.equals("中型数据库"))
			db=new SqlServer();
		else if(dbname.equals("小型数据库"))
			db=new Access();
		return db;
	}
}
