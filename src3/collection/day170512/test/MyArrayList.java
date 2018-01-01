package collection.day170512.test;

public class MyArrayList {
	private Object[] obj;
	private int index;//记录元素下标
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int length){
		obj = new Object[length];
	}

	
	
	public void add(Object o){
		if(index==obj.length-1){
			Object[] newObj = new Object[obj.length*2];
			for(int i=0;i<obj.length;i++){
				newObj[i] = obj[i];
			}
			obj = newObj;
		}
		obj[index++] = o;
	}
	
	
	public void addAll(Object[] o){
		//扩容
		if(obj.length-index<=o.length){
			Object[] newObj = new Object[obj.length+o.length];
			for(int i=0;i<obj.length;i++){
				newObj[i] = obj[i];
			}
			obj = newObj;
		}
		
		for(Object i:o){
			add(i);
		}		
	}
	
	public void addAll(int tIndex,Object[] ss){
		if(tIndex > index){
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		
		//扩容
		if(obj.length-index <= ss.length){
			Object[] newObj = new Object[obj.length+ss.length];
			for(int i=0;i<obj.length;i++){
				newObj[i] = obj[i];
			}
			obj = newObj;			
		}
		
		if(tIndex == index){
			for(Object i:ss){
				add(i);
			}
		}else{
			//把之后的数据储存起来
			Object[] ob = new Object[index-tIndex];
			int tempIndex = 0;
			for(int i=tIndex;i<index;i++){
				ob[tempIndex++] = obj[i];
			}
			
			index = tIndex;
			for(Object i:ss){
				add(i);
			}
			
			for(Object i:ob){
				add(i);
			}
		}
		
		
	}
	
	public void remove(Object data){
		Object[] newObj = new Object[obj.length];
		int tempIndex = 0;
		for(int i=0;i<index;i++){
			if(!data.equals(obj[i])){
				newObj[tempIndex++] = obj[i]; 
			}
		}
		obj = newObj;
		index = tempIndex;
	}
	
	public void removeAll(Object[] ss){
		for(Object i:ss){
			if(contains(i)){
				remove(i);
			}
		}
		
	}
	
	public boolean contains(Object data){
		for(int i=0;i<index;i++){
			if(obj[i].equals(data)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(obj[i]+",");
		}
		return builder.substring(0,builder.length()-1);
	}
}
