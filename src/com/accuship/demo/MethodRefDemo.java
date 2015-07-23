package com.accuship.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javax.print.DocFlavor.STRING;

public class MethodRefDemo {

	public static void main(String[] args) {
		  List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"1", "2", "32", "4", "0"}));
		  int[] lengths1 = list.stream().mapToInt(s -> s.length()).toArray();
		  //s is not defined in method ref, method ref will indicate method in which class, and skip naming the variables.
		  //maybe s -> s::method?
//		  int[] lengths2 = list.stream().mapToInt(s::length).toArray();
		  int[] lengths2 = list.stream().mapToInt(String::length).toArray();

	}
	
	public static void staticMethod() {
		//ClassName::staticMethodName
		//ex: String::valueOf
	    Function<Integer, String> sFunc = String::valueOf;  
	    System.out.println(sFunc.apply(123));    // 123  
	}

	public static void instanceMethod() {
		//ClassName::instanceMehodName
		//ex: String::length
		Function<String, Integer> fn = String::length;
		System.out.println("title..........." + fn.apply("java 8")); //6
	}
	
	public static void instanceMethodUsingObject() {
		//object::instanceMethodName
		//ex: obj::getValue
		Something s = new Something();
		Function<String, String> converter = s::startsWith;
		System.out.println("title..........." + converter.apply("Java")); 	//"J"
	}
}

class Something {
	String startsWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}
