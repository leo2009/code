package com.accuship.demo;

/*
 * 1. get
 * 		1.1 string length:
 * 			int length()
 * 		1.2 get char:
 * 			char charAt(int index)
 * 		1.3 get index:
 * 			int indexOf(....), int lastIndexOf(...)
 * 
 * 
 * 2. determine
 * 		2.1 isContain
 * 			boolean contains(String str) -- check boolean only
 * 			indexOf(..)  				 -- use index also
 * 		2.2 isEmpty
 * 			boolean isEmpty(): length == 0
 * 		2.3 startWith
 * 			boolean startWith(str)
 * 		2.4 endWith
 * 			boolean endWith(str)
 * 		2.5 equal
 * 			boolean equals(str), equalsIgnoreCase();
 * 
 * 3. convert
 * 	 	3.1 char array to string
 * 			String(char[]), String(char[], offset, count)
 * 			copyValueOf(char[]), copyValueOf(char[], offset, count), valueOf(..)
 * 		3.2 string to char array
 * 			char[] toCharArray()
 * 		3.3 byte array to string
 * 			String(byte[]), String(byte[], offset, count)
 * 		3.3 string to byte array
 * 			byte[] getBytes();
 * 		3.4 Case
 * 			toUpperCase, toLowerCase
 * 
 * 4. replace
 * 		replace(old, new), replace(regex, replacement)
 * 
 * 5. split
 * 		String[] split(regex)
 * 
 * 6. subString
 * 		subString(begin), subString(begin,end)  -- include begin not end
 * 
 * 7. compare, remove space
 *		7.1 trim()
 *		7.2 int compareTo(str); 
 *
 * 
 */



public class StringDemo {

	public static void main(String[] args) {
		get();
		determine();
		convert();
		replace();
		split();
		compare();
	}
	
	public static void get() {
		String str = "abcdefgc";
		
		//length
		System.out.println("length..........." + str.length());
		
		//get char
		System.out.println("get char..........." + str.charAt(2));
		
		//get index
		System.out.println("index..........." + str.indexOf('c', 3));
		System.out.println("index..........." + str.lastIndexOf("c"));
	}
	
	public static void determine() {
		String str = "array.txt";
		
		//startWith
		System.out.println("start..........." + str.startsWith("array"));
		
		//endWith
		System.out.println("end..........." + str.endsWith("txt"));
		
		//contain
		System.out.println("contain..........." + str.contains("txt"));
		
	}
	
	public static void convert() {
		char[] arr = {'a', 'b', 'c', 'd'};
		
		//char[] to str
		String str = new String(arr);
		System.out.println("char[] to..........." + str);
		str = new String(arr, 1, 2);
		System.out.println("parts of char[]..........." + str);
	}
	
	public static void replace() {
		String s = "hello.java";
		
		String s1 = s.replace('a', 'n');
		String s2 = s.replace('q', 'n');
		
		System.out.println("replace..........." + s);
		System.out.println("new..........." + s1);
		System.out.println("if not found..........." + s2);
	}
	
	public static void split() {
		String s = "leo,lisi,wangwu";
		String[] arr = s.split(",");
		
		for(String str : arr) {
			System.out.println("split..........." + str);
		}
		
	}
	
	public static void compare() {
		String s = "  hello   ";
		System.out.println("trim..........." + s.trim());
		
		String s1 = "abc";
		String s2 = "aaa";
		System.out.println("compare..........." + s1.compareTo(s2));
	}
	

}
