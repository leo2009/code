package com.accuship.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * sort, max, fill, replaceAll(list, old, new), reverse(list), swap(list, i, j), shuffle(list)
 * Comparator<T> reverseOrder([Comparator]) (may be used for treeSet) : TreeSet<String> ts = new TreeSet<String>(Collection.reverseOrder());
 * new TreeSet<String>(Collection.reverseOrder(new MyComparator()))
 * 
 * 
 * synchronizedList, synchronizedMap ...
 * return thread safe and high efficient container
 */
public class CollectinsUtilDemo {

	public static void main(String[] args) {
		sortDemo();
		fillDemo();
	}
	
	public static void sortDemo() {
		List<String> l  = new ArrayList<String>();
		
		l.add("avcx");
		l.add("aaa");
		l.add("z");
		l.add("qq");
		l.add("aa");
		System.out.println("original..........." + l);
		Collections.sort(l);
		
		System.out.println("new1..........." + l);
		System.out.println("max..........." + Collections.max(l));
		Collections.sort(l, new lenComparator());
		System.out.println("title2..........." + l);
		System.out.println("max with comparator..........." + Collections.max(l, new lenComparator()));
		
		
	}
	
	public static void fillDemo() {
		List<String> l  = new ArrayList<String>();
		
		l.add("avcx");
		l.add("aaa");
		l.add("z");
		l.add("qq");
		
		System.out.println("title..........." + l);
		Collections.fill(l, "oo");
		System.out.println("fill..........." + l);
	}
}

class lenComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() > o2.length())
			return 1;
		else if (o1.length() < o2.length())
			return -1;
		else
			return o2.compareTo(o1);
	}
	
}