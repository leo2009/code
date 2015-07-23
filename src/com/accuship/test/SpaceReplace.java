package com.accuship.test;


public class SpaceReplace {

	public static void main(String[] args) {
		replace("Mr John Smith", new char[] {'m','r',' ', 'j', 'o', 'y'});
	}
	
	public static void replace(String str, char[] string) {
		StringBuilder sb = new StringBuilder();
		sb.append(string);
		String test = sb.toString().replaceAll("\\s", "%20");
		String res = str.replaceAll("\\s", "%20");
		System.out.println("title..........." + test);
		System.out.println("title..........." + res);
	}

}
