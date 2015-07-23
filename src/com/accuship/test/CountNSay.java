package com.accuship.test;

import java.util.Arrays;

public class CountNSay {

	public static void main(String[] args) {
//		System.out.println("title..........." + getString("11"));
//		for(int i=1; i<10; i++) {
//			System.out.println("title..........." + countAndSay(i));
//		}
		Integer[] arr = new Integer[] {2147483642,2147483644,2147483646,2147483647};
		partitionArray(arr);
		System.out.println("title..........." + Arrays.asList(arr) );
	}
	
    public static String countAndSay(int n) {
    	String res = "1";
    	for(int i=1; i<n; i++) {
    		res = getString(res);
    	}
    	return res;
    }
    

    public static String getString(String s) {
        int count = 1;
        if(s.length() == 1) return  "" + count + s;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                count++;
                if(i == s.length() - 2) sb.append("" + count + s.charAt(i));
            }else {
                sb.append("" + count+s.charAt(i));
                count = 1;
                if(i == s.length() - 2) sb.append("" + count + s.charAt(i + 1));
            }
        }
        return sb.toString();
    }
    
    
    public static void partitionArray(Integer[] nums) {
        // write your code here;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=0; j<nums.length-1; j++) {
                if(!isOdd(nums[j]) && isOdd(nums[j+1])) {
                    swap(nums, j, j+1);
                }
                System.out.println("new..........." + Arrays.asList(nums));
            }
        }
    }
    
    public static void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static boolean isOdd(int num) {
        return num%2 != 0;
    }

}
