package collection.day170517.test11;

public class MyArrayList {
	private String[] datas;
	private int size = 0;
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int length){
		datas = new String[length];
	}
	
	//扩容
	private void expand(){		
		String[] newS = new String[datas.length*2];
		for(int i=0;i<size;i++){
			newS[i] = datas[i];
		}
		datas = newS;
	}
	public void add(String str){
		if(size==datas.length){
			expand();
		}
		datas[size++] = str;
	}
	
	public void add(int index,String str){
		if(index<0 || index>size){
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		if(size==datas.length){
			expand();		
		}
		
		System.arraycopy(datas, index, datas, index+1, size-index);
		datas[index] = str;
		size++;
	}
	
	public String[] getDatas(){
		return datas;
	}
	
	public void addAll(MyArrayList ml){
		String[] strs = ml.getDatas();
		int num = strs.length;//新增元素的个数
		//扩容
		if(datas.length-size<num){
			expand(num);
		}
		
		//将新数组元素copy到原数组
		System.arraycopy(strs, 0, datas, size, num);
		size += num;
	}
	
	//通过新数组元素个数扩容
	private void expand(int num){
		String[] newS = new String[size+num];
		for(int i=0;i<size;i++){
			newS[i] = datas[i];
		}
		datas = newS;	
	}
	
	public void addAll(int index,MyArrayList ml){
		if(index<0 || index>size){
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		
		
		
		String[] strs = ml.getDatas();
		int num = strs.length;//要添加数组的元素个数
		if(datas.length-size<num){
			expand(num);
		}
		int move = size-index;//原数组要移动的个数
		System.arraycopy(datas, index, datas, index+num, move);
		
		//将新数组copy到原数组
		System.arraycopy(strs,0, datas, index, num);
		size += num;
	}
	
	public boolean containsAll(MyArrayList ml){
		String[] strs = ml.getDatas();
		for (String s : strs) {
			if(s==null){
				continue;
			}
			if(!contains(s)){
				return false;
			}
		}
		return true;
	}
	
	private boolean contains(String str){
		for (String temp : datas) {
			if(temp==null){
				continue;
			}
			
			if(str.equals(temp)){
				return true;
			}
		}
		return false;
	}
	
	public boolean retain(String str){
		for (String temp : datas) {
			if(temp.equals(str)){
				return true;
			}
		}
		return false;
	}
	
	public void retainAll(MyArrayList ml){
		String[] strs = ml.getDatas();
		for (String temp : strs) {
			if(!retain(temp)){//将不包含在内的删除
				remove(temp);
			}
		}
	}
	
	public void remove(String str){
		if(contains(str)){
			//新建一个数组用来存储删除后的元素
			String[] newS = new String[datas.length];
			int tempIndex = 0;
			for(int i=0;i<size;i++){
				if(!datas[i].equals(str)){
					newS[tempIndex++] = datas[i];
				}
			}
			datas = newS;
			size = tempIndex;
		}
		size--;
	}
	
	public void removeAll(MyArrayList ml){
		String[] strs = ml.getDatas();
		for (String temp : strs) {
			remove(temp);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();	
		builder.append("[");
		for(int i=0;i<size;i++){
			builder.append(datas[i]+",");
		}	
		return builder.substring(0, builder.length()-1)+"]";
	}
}
