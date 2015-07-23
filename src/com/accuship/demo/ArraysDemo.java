package com.accuship.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 1.array convert to list: Arrays.asList()
 * pro of convert arr to list
 * be careful!!!!: returned list is NOT allowed to add or remove operation after Arrays.asList();
 * 				   or throw UnsportedOperationException
 * 
 * 
 * 2.list convert to array: toArray(T[] a) in Collection interface
 * 
 */

public class ArraysDemo {

	public static void main(String[] args) {
		
		int[] num1 = {2, 3, 5};
		Integer[] num2 = {2, 3, 5};
		List<int[]> l1 = Arrays.asList(num1);
		List<Integer> l2 = Arrays.asList(num2);
		
		System.out.println("title..........." + l1);// use IntStream: IntStream is = Arrays.stream(num1);
		
		System.out.println("title..........." + l2);
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("java1");
		al.add("java2");
		al.add("java3");
		al.add("java4");
		
		String[] arr1 = al.toArray(new String[al.size()]); // arr length better be the list size 
		String[] arr3 = al.toArray(new String[0]); //if length is smaller, create another new array in memory
		String[] arr2 = al.toArray(new String[10]);
		
		
		System.out.println("title..........." + Arrays.toString(arr1));
		System.out.println("title..........." + Arrays.toString(arr2));
		
		

	}

}
