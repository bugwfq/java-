package collection.day170512.work;

public class MyArrayList {
	private String[] s;
	private int index;
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int length){
		s = new String[length];
	}
	
	public void add(String str){
		//����
		if(index==s.length-1){
			String[] newS = new String[s.length*2];
			for(int i=0;i<index;i++){
				newS[i] = s[i];
			}
			s = newS;
		}
		
		s[index++] = str;
	}
	
	public void addAll(String[] ss){
		if(s.length-index <= ss.length){//ʣ��Ŀռ䲻���洢�����飬����Ҫ����
			String[] newS = new String[s.length+ss.length];
			for(int i=0;i<index;i++){
				newS[i] = s[i];
			}
			s = newS;			
		}
		
		//����������ӵ�ԭ����ĩβ
		for(String i:ss){
			add(i);
		}
	}
	
	public void addAll(int tIndex,String[] ss){
		//��ʣ��Ŀռ䲻���洢������ʱ��Ҫ����
		if(s.length-index <= ss.length){
			String[] newS = new String[s.length+ss.length];
			for(int i=0;i<index;i++){
				newS[i] = s[i];
			}
			s = newS;
		}
		
		if(tIndex == index){//ָ��λ����ԭ�����ĩβ,ֱ����ӵ�ĩβ
			for(String i:ss){
				add(i);
			}
		}else{
			//����һ�����ȱ�������
			String[] newS = new String[index-tIndex];
			int tempIndex = 0;
			for(int i=tIndex;i<index;i++){
				newS[tempIndex++] = s[i];
			}
			
			//����������ӵ�ָ��λ��
			index = tIndex;
			for(String i:ss){
				add(i);
			}
			
			//������һ����������ӵ�����ĩβ
			for(String i:newS){
				add(i);
			}
			
		}
	}
	
	private boolean contain(String data){
		for(int i=0;i<index;i++){
			if(s[i].equals(data)){
				return true;
			}
		}
		return false;
	}
	
	
	public int indexOf(String data){
		for(int i=0;i<index;i++){
			if(s[i].equals(data)){
				return i;
			}
		}
		return -1;
	}
	
	public void remove(String data){
		if(indexOf(data)!=-1){
			String[] newS = new String[index];
			int temp = 0;
			for(int i=0;i<index;i++){
				if(i!=indexOf(data)){
					newS[temp++] = s[i];				
				}
			}
			s = newS;
			index = temp;
		}
	}
	
	
	public void removeAll(String[] ss){
		for(String i:ss){
			if(contain(i)){
				remove(i);
			}
		}
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(s[i]+",");
		}
		return builder.substring(0, builder.length()-1);
	}
}
