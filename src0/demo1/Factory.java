package demo1;

public class Factory {//����Factory��
	public static DataBase CreatObj(){
		DataBase db =null;
		String dbname="�������ݿ�";
		if(dbname.equals("�������ݿ�"))
			db=new Oracle();
		else if(dbname.equals("�������ݿ�"))
			db=new SqlServer();
		else if(dbname.equals("С�����ݿ�"))
			db=new Access();
		return db;
	}
}
