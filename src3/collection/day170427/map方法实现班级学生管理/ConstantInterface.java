package collection.day170427.map����ʵ�ְ༶ѧ������;

public interface ConstantInterface {
	
	//���˵�
	public static final int LOGIN = 1;
	public static final int ADDUSER = 2;
	
	//����Ա�˵�
	public static final int ADMINMENU = 1;
	//����Ա�༶����˵�
	public static final int CLASSESMANAGER = 1;
	//����Աѧ������˵�
	public static final int STUDENTMANAGER = 2;
	
	//���Ӱ༶	
	public static final int ADMIN_ADD_CLASSES = 1;
	//ɾ���༶
	public static final int ADMIN_DELETE_CLASSES = 2;
	//�޸İ༶
	public static final int ADMIN_UPDATE_CLASSES = 3;
	//�鿴�����༶��Ϣ
	public static final int ADMIN_QUERY_SINGLE_CLASSES = 4;
	//�鿴�༶��Ϣ
	public static final int ADMIN_CLASSES_LIST = 5;
	
	//����ѧ��	
	public static final int ADMIN_ADD_STUDENT = 1;
	//ɾ��ѧ��
	public static final int ADMIN_DELETE_STUDENT = 2;
	//�޸�ѧ��
	public static final int ADMIN_UPDATE_STUDENT = 3;
	//�鿴����ѧ����Ϣ
	public static final int ADMIN_QUERY_SINGLE_STUDENT = 4;
	//�鿴ѧ����Ϣ
	public static final int ADMIN_STUDENT_LIST = 5;
	
	//�鿴�����༶��Ϣ
	public static final int COMMON_QUERY_SINGLE_CLASSES = 1;
	//�鿴�༶��Ϣ
	public static final int COMMON_CLASSES_LIST = 2;
	
	//�鿴����ѧ����Ϣ
	public static final int COMMON_QUERY_SINGLE_STUDENT = 1;
	//�鿴ѧ����Ϣ
	public static final int COMMON_STUDENT_LIST = 2;

	//�鿴ĳ���༶���µ���Ů����
	public static final int QUERYBOYSANDGIRLSBYCLSID = 1;
	//�鿴ĳ�༶���µ�������䣬��С���䣬ƽ������
	public static final int QUERYMAXAGEVSMINAGEVSAVERAGEAGE = 2;
	//ͳ��ȫУ��Ů����
	public static final int QUERYALLBOYSANDGIRLS = 3;
	//�鿴ȫУ���������ѧ������С�����ѧ��
	public static final int QUERYMAXAGESTUANDMINAGESTU = 4;
	
	//��������
	public static final int REPORTMANAGER = 3;
	//�˳�
	public static final int EXIT = 0;
}
