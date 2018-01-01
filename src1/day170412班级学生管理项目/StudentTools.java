package day170412�༶ѧ��������Ŀ;

public class StudentTools {

	public static StudentNode getSNodeByCNodeAndStuId(ClassesNode cNode,int id){
		
		// �øð༶���µĵ�һ��ѧ����Ϊ�ð༶ѧ�������"ͷ"
		StudentNode temp = cNode.getDown();
		
		while(temp != null){
			if(temp.getStudent().getId() == id){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
	
	public static StudentNode getLastStudentByCNode(ClassesNode cNode){
		StudentNode temp = cNode.getDown();
		
		while(temp != null){
			if(temp.getAfter() == null){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
}
