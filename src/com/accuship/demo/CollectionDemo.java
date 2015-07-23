package com.accuship.demo;

import java.util.*;

public class CollectionDemo {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		//1.add
		al.add("java1");
		al.add("java2");
		al.add("java3");
		
		//2.size
		System.out.println("size..........." + al.size());
		
		//3.determine
		System.out.println("contain..........." + al.contains("java1"));
		System.out.println("is empty..........." + al.isEmpty());
		
		//4.delete
		al.remove("java1");
		System.out.println("remove..........." + al);
		
		al.clear();
		System.out.println("after clear..........." + al);
		
		intersect();
	}
	
	public static void intersect() {
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		
		a1.add("java1");
		a1.add("java2");
		a1.add("java3");
		
		a2.add("java1");
		a2.add("java4");
		a2.add("java5");
		
		a1.retainAll(a2);
		System.out.println("intersect..........." + a1);
		a1.add("java");
		
		a1.removeAll(a2);
		System.out.println("removeall..........." + a1);
		
	}
	
	public static void get() {
		ArrayList al = new ArrayList();
		
		al.add("java1");
		al.add("java2");
		al.add("java3");
		
		Iterator it = al.iterator();
		while(it.hasNext()) {
			System.out.println("next..........." + it.next());
		}
		
		for(Iterator i = al.iterator(); i.hasNext();) {
			System.out.println("next..........." + i.next());
		}
	}
}
