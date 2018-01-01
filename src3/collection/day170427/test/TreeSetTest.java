package collection.day170427.test;

import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {
	@Test
	public void test1(){
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		System.out.println(treeSet.size());
		TreeSet<Integer> newTreeSet = new TreeSet<>();
		newTreeSet.addAll(treeSet);
		System.out.println(newTreeSet);
		System.out.println(treeSet.ceiling(2));//返回此 set 中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null。
		System.out.println(treeSet.first());// 返回此 set 中当前第一个（最低）元素
		System.out.println(treeSet.floor(1));// 返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null
		System.out.println(treeSet.higher(2));//返回此 set 中严格大于给定元素的最小元素；如果不存在这样的元素，则返回 null。
		
	}
}
