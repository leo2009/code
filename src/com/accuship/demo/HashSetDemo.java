package com.accuship.demo;

import java.util.HashSet;


public class HashSetDemo {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		
		hs.add(new Person("a1", 11));
		hs.add(new Person("a2", 12));
		hs.add(new Person("a3", 13));
		
		System.out.println("a1:" + hs.contains(new Person("a2", 12)));
		
	}

}

class Person {
	private int age;
	private String name;
	Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	public int hashCode() {
		System.out.println("hashCode run..........." + name);
//		return 60;
		return name.hashCode() + age*39;
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Person))
			return false;
		
		Person p = (Person) o;
		System.out.println(this.name + "...equals..." + p.name);
		return this.name.equals(p.name) && this.age == p.age;
	}
}
