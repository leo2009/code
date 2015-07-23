package com.accuship.demo;

import java.util.LinkedList;

/*
 * LinkedList: addfirst/last, getFirst/last, removeFirst/last(throws exception)
 * after jdk1.6 offerfirst/last, peekfirst/last, pollfirst/last(no exception)
 */

public class LinkListDemo {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		
		l.addFirst("java1");
		l.addFirst("java2");
		l.addFirst("java3");
		System.out.println("title..........." + l);
		System.out.println("get..........." + l.getLast());
	}

}
