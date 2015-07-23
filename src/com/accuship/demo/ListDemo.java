package com.accuship.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * list: all the index operations are from here
 * 		 ArrayList: after jdk1.2, low layer is array same as vector with index, thread not safe, so need lock
 * 		 vector: jdk1.0, thread safe. use ArrayList even when multi-thread (use lock)
 * 		 LinkList: lian biao
 * 1.c
 * 		add(index, ele)
 * 		addAll(index, collection)
 * 2.r
 * 		get(index)
 * 		subList(from, to)
 * 		indexOf(..)
 * 		listIterator();
 * 3.u
 * 		set(index, ele);
 * 4.d
 * 		remove(index)
 * 
 * 5.listIterator
 */

public class ListDemo {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		al.add("java1");
		al.add("java2");
		al.add("java3");
		al.add("java4");
		
		Iterator it = al.iterator();
		while(it.hasNext()) {
			Object ob = it.next();
			if(ob.equals("java2")) {
//				al.remove(ob); -- can't use al inside it
				it.remove(); // use it but it can't add so use child listItorator -> could crud
			}
		}
		
		ListIterator li = al.listIterator();
		while(li.hasNext()) {
			Object ob = li.next();
			if(ob.equals("java2")) {
				li.set("java8");
			}
		}
		
		while(li.hasPrevious()) {
			Object ob = li.previous();
			if(ob.equals("java3")) {
				li.add("java0");
			}
		}
		
		System.out.println("title..........." + al);
	}

}
