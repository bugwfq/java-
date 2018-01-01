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
		System.out.println(treeSet.ceiling(2));//���ش� set �д��ڵ��ڸ���Ԫ�ص���СԪ�أ����������������Ԫ�أ��򷵻� null��
		System.out.println(treeSet.first());// ���ش� set �е�ǰ��һ������ͣ�Ԫ��
		System.out.println(treeSet.floor(1));// ���ش� set ��С�ڵ��ڸ���Ԫ�ص����Ԫ�أ����������������Ԫ�أ��򷵻� null
		System.out.println(treeSet.higher(2));//���ش� set ���ϸ���ڸ���Ԫ�ص���СԪ�أ����������������Ԫ�أ��򷵻� null��
		
	}
}
