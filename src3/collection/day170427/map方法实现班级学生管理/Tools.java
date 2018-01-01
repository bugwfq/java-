package collection.day170427.map方法实现班级学生管理;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tools {
	
	/**
	 * 通过班级名获取班级
	 */
	
	public static Classes getClsByClsName(String clsName){
		Set<Integer> keys = ClassesManager.clsMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer clsId = iter.next();
			Classes cls = ClassesManager.clsMap.get(clsId);
			if(cls.getClsName().equals(clsName)){
				return cls;
			}
		}
		return null;
	}
	
}
