package com.accuship.demo;

/*
 * it is a String container: string can't be changed as long as it is created. buffer could be changed
 * 
 * container: 1.CRUD, 2.varable length, 3. multiple type operation
 * 1.c
 * 		StringBuffer append(..)
 * 		StringBuffer insert(index, data);
 * 		
 * 2.d
 * 		StringBuffer delete(start, end)
 * 		StringBuffer deleteCharAt(index)
 * 3.r
 * 		char charAt(index), indexOf(), lastIndexOf(), length(), String subString(start, end) 
 * 4.u
 * 		StringBuffer replace(start, end)
 * 		void setCharAt(index, char)
 * 5.reverse
 * 		StringBuffer reverse()
 * 6. void getChars(scrBegin, srcEnd, char[] dst, int dstBegin)
 * 
 * 
 * after jdk1.5, StringBuilder
 * buffer: thread safe
 * builder: not safe, but efficient
 * 
 */

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("assadf");
		StringBuffer sb1 = sb.append("abcd");
		
		System.out.println("sb..........." + sb.toString());
		System.out.println("sb1..........." + sb1.toString());
		System.out.println("sb and sb1 are the same container...........sb == sb1:" + (sb==sb1));
		
		//so just use 1 StringBuffer is enough
		System.out.println("inset..........." + sb.insert(1, "qq"));
	}
	
	public static void del() {
		StringBuffer sb = new StringBuffer("asdasg");
		
		//delete all
		sb.delete(0, sb.length());
	}
	
	public static void repl() {
		StringBuffer sb = new StringBuffer("assadf");
		
		sb.replace(0, 3, "java");
		sb.setCharAt(4, 'q');
		
	}

}
