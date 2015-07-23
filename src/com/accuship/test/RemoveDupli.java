package com.accuship.test;

import java.util.Arrays;

public class RemoveDupli {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {-10, 0, 1, 2, 3};
		System.out.println("res..........." + removeDuplicates(arr));
		System.out.println("arr..........." + Arrays.asList(arr));
	}
	
    public static int removeDuplicates(Integer[] nums) {
        // write your code here
        if(nums == null || nums.length==0) return 0;
        int p = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[p]) {
                nums[++p] = nums[i];
            }
            System.out.println("p..........." + nums[p]);
            System.out.println("i..........." + nums[i]);
        }
        return p+1;
    }

}
