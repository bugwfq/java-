package collection.day170427.map����ʵ�ְ༶ѧ������;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tools {
	
	/**
	 * ͨ���༶����ȡ�༶
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
