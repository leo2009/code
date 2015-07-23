package com.accuship.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareString {

	public static void main(String[] args) {
		System.out.println("title..........." + compareString("abcd", "acbe"));
	}
	
	public static boolean compareString(String A, String B) {
		String[] arrA = A.split("");
		String[] arrB = B.split("");
		List<String> al = new ArrayList<String>(Arrays.asList(arrA));
		List<String> bl = new ArrayList<String>(Arrays.asList(arrB));
		for(int i=0; i<bl.size(); i++) {
			if(al.contains(bl.get(i))) {
				al.remove(bl.get(i));
			}else {
				return false;
			}
		}
		return true;
	}

}
