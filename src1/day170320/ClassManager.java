package day170320;

import java.util.Scanner;

/**
 * �༶������
 * 
 * @author Administrator
 *
 */
public class ClassManager {

	public static Classes[] cs = new Classes[10];
	public static int index;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * ���Ӱ༶
	 */
	public void addClasses(){
		
		System.out.println("������༶id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);//�����ѧ��ǰ�����ж�������Ƿ����
		if(c != null){
			System.out.println("����ӵİ༶id�Ѵ���.");
			return ;
		}
		
		System.out.println("������༶����:");
		String cName = sc.next();
		
		System.out.println("������༶����:");
		String cDesc = sc.next();
		
		// ����һ���µĶ���
		Classes newC = new Classes(cid, cName, cDesc);
		cs[index] = newC;
		index ++;
		System.out.println("�����ɹ�.");
	}
	
	/**
	 * ɾ���༶(����)
	 */
	public void deleteClasses(){
		
		System.out.println("��������Ҫɾ���İ༶id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);//Ҫɾ���༶ǰ����ͨ���༶id�жϰ༶�Ƿ����
		if(c == null){
			System.out.println("��Ҫɾ���İ༶id������.");
			return ;
		}
		
		// ��Ҫɾ���İ����ʱ�����жϸð༶�����Ƿ���ѧ��
		Student[] s = Tools.getStudentsByClassId(cid);
		if(s.length != 0){// ˵����ѧ����ֱ��ɾ��ѧ����Ϣ
			StudentManager stuManager = new StudentManager();
			stuManager.deleteBatch(s); // ���ð��е�����ѧ����Ϣɾ��
		}
		//��Ҫɾ���༶�µ�����ѧ��ɾ������ɾ�������
		Classes[] temp = new Classes[cs.length];
		int tempIndex = 0;
		for(int i = 0;i<index;i++){
			if(cs[i].getClassId() != cid){
				temp[tempIndex] = cs[i];
				tempIndex ++;
			}
		}
		
		cs = temp;
		index --;
		System.out.println("ɾ���ɹ�.");
	}
	
	/**
	 * �޸İ༶��Ϣ(����)
	 */
	public void updateClasses(){
		System.out.println("��������Ҫ�޸ĵİ༶id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("��Ҫ�޸ĵİ༶id������.");
			return ;
		}
		
		System.out.println("�������µİ༶id:");
		int newCid = sc.nextInt();
		Classes newC = Tools.getClassesByCid(newCid);
		if(newC != null){
			System.out.println("�µİ༶id�Ѵ���.");
			return ;
		}
		
		// �ж��޸ĵİ༶�����Ƿ���ѧ���������ѧ������ѧ���İ༶idҲҪ�ĳ��޸ĺ��id
		Student[] s = Tools.getStudentsByClassId(cid);
		if(s.length != 0){
			for(Student ss:s){
				ss.setClassId(newCid);
			}
		}
		
		c.setClassId(newCid);
		System.out.println("�޸ĳɹ�.");
	}
	
	/**
	 * ��ѯ�����༶��Ϣ
	 */
	public void querySingleClasses(){
		
		System.out.println("��������Ҫ��ѯ�İ༶id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("��Ҫ��ѯ�İ༶id������.");
			return ;
		}
		System.out.println("�༶��Ϣ�磺"+c);
	}
	
	/**
	 * ��ѯ���а༶��Ϣ
	 */
	public void classesList(){
		
		if(index == 0){
			System.out.println("��ǰû���κΰ༶��Ϣ");
			return ;
		}
		System.out.println("���а༶��Ϣ����:");
		for(int i = 0;i<index;i++){ // i<cs.length;
			System.out.println(cs[i]);
		}
	}
}
