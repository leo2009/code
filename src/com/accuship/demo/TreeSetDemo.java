package com.accuship.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/*
 * set: orderless
 * 		hashSet: hash table, thread not safe
 * 		treeSet: could sort element
 */
public class TreeSetDemo {

	public static void main(String[] args) {
		showSorted();
		TreeSet ts = new TreeSet();
		
		ts.add(new Student("leo1", 22));
		ts.add(new Student("leo2", 22));
		ts.add(new Student("leo3", 24));
		
		TreeSet t2 = new TreeSet(new MyCompare());
		
		t2.add(new Student("leo1", 22));
		t2.add(new Student("leo2", 22));
		t2.add(new Student("leo3", 24));
		
		Iterator it  = ts.iterator();
		while(it.hasNext()) {
			System.out.println("sorted with comparable..........." + ((Student)it.next()).name);
		}
		
		Iterator it2  = t2.iterator();
		while(it2.hasNext()) {
			System.out.println("sorted with comparator..........." + ((Student)it2.next()).name);
		}
		
	}
	
	public static void showSorted() {
		TreeSet ts = new TreeSet();
		
		ts.add("b");
		ts.add("c");
		ts.add("aa");
		ts.add("ab");
		
		Iterator it  = ts.iterator();
		while(it.hasNext()) {
			System.out.println("sorted..........." + it.next());
		}
	}
	
}

//must implement comparable if put this into treeset or create treeset with comparator arg (new TreeSet(Comparator))
class Student implements Comparable{
	String name;
	int age;
	
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Student))
			throw new RuntimeException("not student obj");
		Student s = (Student) o;
		if(this.age > s.age)
			return 1;
		else if(this.age == s.age)
			return this.name.compareTo(s.name);
		else
			return -1;

	}
}

class MyCompare implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
		int res = s1.name.compareTo(s2.name);
		if(res == 0) {
			return new Integer(s1.age).compareTo(new Integer(s2.age));
		}
		return res;
	}
	
}
