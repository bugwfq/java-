package collection.day170427.map方法实现班级学生管理;

public interface ConstantInterface {
	
	//主菜单
	public static final int LOGIN = 1;
	public static final int ADDUSER = 2;
	
	//管理员菜单
	public static final int ADMINMENU = 1;
	//管理员班级管理菜单
	public static final int CLASSESMANAGER = 1;
	//管理员学生管理菜单
	public static final int STUDENTMANAGER = 2;
	
	//增加班级	
	public static final int ADMIN_ADD_CLASSES = 1;
	//删除班级
	public static final int ADMIN_DELETE_CLASSES = 2;
	//修改班级
	public static final int ADMIN_UPDATE_CLASSES = 3;
	//查看单个班级信息
	public static final int ADMIN_QUERY_SINGLE_CLASSES = 4;
	//查看班级信息
	public static final int ADMIN_CLASSES_LIST = 5;
	
	//增加学生	
	public static final int ADMIN_ADD_STUDENT = 1;
	//删除学生
	public static final int ADMIN_DELETE_STUDENT = 2;
	//修改学生
	public static final int ADMIN_UPDATE_STUDENT = 3;
	//查看单个学生信息
	public static final int ADMIN_QUERY_SINGLE_STUDENT = 4;
	//查看学生信息
	public static final int ADMIN_STUDENT_LIST = 5;
	
	//查看单个班级信息
	public static final int COMMON_QUERY_SINGLE_CLASSES = 1;
	//查看班级信息
	public static final int COMMON_CLASSES_LIST = 2;
	
	//查看单个学生信息
	public static final int COMMON_QUERY_SINGLE_STUDENT = 1;
	//查看学生信息
	public static final int COMMON_STUDENT_LIST = 2;

	//查看某个班级底下的男女生数
	public static final int QUERYBOYSANDGIRLSBYCLSID = 1;
	//查看某班级地下的最大年龄，最小年龄，平均年龄
	public static final int QUERYMAXAGEVSMINAGEVSAVERAGEAGE = 2;
	//统计全校男女生数
	public static final int QUERYALLBOYSANDGIRLS = 3;
	//查看全校最大的年龄的学生，最小年龄的学生
	public static final int QUERYMAXAGESTUANDMINAGESTU = 4;
	
	//报表中心
	public static final int REPORTMANAGER = 3;
	//退出
	public static final int EXIT = 0;
}
