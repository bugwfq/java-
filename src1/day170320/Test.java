package day170320;

import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ClassManager csmana = new ClassManager();
		StudentManager stumana = new StudentManager();
		boolean flag1 = true;
		while(flag1){	
			System.out.println("--------��ӭʹ����ͨѧ������ϵͳ--------");
			System.out.println("1.�༶����2.ѧ������0.�˳�ϵͳ");
			System.out.println("��ѡ��");
			int mark = input.nextInt();
			if(mark==1){//1.�༶����
				boolean flag2 = true;
				while(flag2){
					System.out.println("1.���Ӱ༶2.ɾ���༶3.�޸İ༶��Ϣ4.��ѯ�����༶��Ϣ5.��ѯ���а༶��Ϣ0.������һ��");
					System.out.println("��ѡ��");
					int temp1 = input.nextInt();
					if(temp1==1){//1.���Ӱ༶
						csmana.addClasses();
					}else if(temp1==2){//2.ɾ���༶
						csmana.deleteClasses();
					}else if(temp1==3){//3.�޸İ༶��Ϣ
						csmana.updateClasses();
					}else if(temp1==4){//4.��ѯ�����༶��Ϣ
						csmana.querySingleClasses();
					}else if(temp1==5){//5.��ѯ���а༶��Ϣ
						csmana.classesList();
					}else{//0.�˳�ϵͳ
						flag2 = false;
					}
				}
			}else if(mark==2){//2.ѧ������
				boolean flag3 = true;
				while(flag3){
					System.out.println("1.����ѧ��2.ɾ��ѧ��3.��ѯѧ��4.��ѯ����ѧ����Ϣ5.�޸�ѧ����Ϣ6.��ѯĳ���������ѧ����Ϣ7.��ѯĳ���༶������������ѧ������С�����ѧ��8.��ѯĳ���༶������Ů������0.������һ��");
					System.out.println("��ѡ��");
					int temp2 = input.nextInt();
					if(temp2==1){//1.����ѧ��
						stumana.addStudent();
					}else if(temp2==2){//2.ɾ��ѧ��
						stumana.deleteStudent();
					}else if(temp2==3){//3.��ѯѧ��
						stumana.querySingleStudent();
					}else if(temp2==4){//4.��ѯ����ѧ����Ϣ
						stumana.queryAllStudent();
					}else if(temp2==5){//5.�޸�ѧ����Ϣ
						stumana.updateStudent();
					}else if(temp2==6){//6.��ѯĳ���������ѧ����Ϣ
						System.out.println("������Ҫ��ѯ�İ༶id:");
						int cid = input.nextInt();
						Classes c = Tools.getClassesByCid(cid);
						stumana.queryStudentByClassId(c.getClassId());
					}else if(temp2==7){//7.��ѯĳ���༶������������ѧ������С�����ѧ��
						System.out.println("������Ҫ��ѯ�İ༶id:");
						int cid = input.nextInt();
						Classes c = Tools.getClassesByCid(cid);
						stumana.queryMaxAgeVsMinAgeByClassId(c.getClassId());
					}else if(temp2==8){//8.��ѯĳ���༶������Ů������
						System.out.println("������Ҫ��ѯ�İ༶id:");
						int cid = input.nextInt();
						Classes c = Tools.getClassesByCid(cid);
						stumana.queryBoysAndGirlsByClassId(c.getClassId());
					}else{//0.������һ��
						flag3 = false;
					}
				}
			}else{//0.�˳�ϵͳ
				System.exit(0);
			}
		}
	}
}
