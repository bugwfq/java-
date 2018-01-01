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
		//扩容
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
		if(s.length-index <= ss.length){//剩余的空间不够存储新数组，就需要扩容
			String[] newS = new String[s.length+ss.length];
			for(int i=0;i<index;i++){
				newS[i] = s[i];
			}
			s = newS;			
		}
		
		//将新数组添加到原数组末尾
		for(String i:ss){
			add(i);
		}
	}
	
	public void addAll(int tIndex,String[] ss){
		//当剩余的空间不够存储新数组时需要扩容
		if(s.length-index <= ss.length){
			String[] newS = new String[s.length+ss.length];
			for(int i=0;i<index;i++){
				newS[i] = s[i];
			}
			s = newS;
		}
		
		if(tIndex == index){//指定位置是原数组的末尾,直接添加到末尾
			for(String i:ss){
				add(i);
			}
		}else{
			//将后一部分先保存起来
			String[] newS = new String[index-tIndex];
			int tempIndex = 0;
			for(int i=tIndex;i<index;i++){
				newS[tempIndex++] = s[i];
			}
			
			//将新数组添加到指定位置
			index = tIndex;
			for(String i:ss){
				add(i);
			}
			
			//最后将最后一部分重新添加到数组末尾
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
