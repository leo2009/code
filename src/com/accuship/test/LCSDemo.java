package com.accuship.test;

public class LCSDemo {

	public static void main(String[] args) {

//		System.out.println("title..........." + longestCommonSubstring("abcd", "dbc"));
//		print2D();
		System.out.println("title..........." + atoi("    52lintcode   "));
	}
    public static int longestCommonSubstring(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int max = 0;
        int[][] arr = new int[lengthB][lengthA];
        for(int i=0; i<lengthB; i++) {
            for (int j=0; j<lengthA; j++) {
                if(a.charAt(j) == b.charAt(i)) {
                    if(i>0 && j>0){
                        arr[i][j] = arr[i-1][j-1] + 1;
                    }else {
                        arr[i][j] = 1;
                    }
                if(arr[i][j] > max) max = arr[i][j];
                }
                System.out.print(arr[i][j]);
                
            }
            System.out.println();
        }
        return max;
    }
    
    public static void print2D() {
    	int[][] arr = new int[5][2];
    	arr[0][1] = 1;
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<2; j++) {
//    			System.out.print(j);
    			arr[i][j] = i;
    			System.out.print(arr[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public static int atoi(String str) {
        // write your code here
        double tmp = 0;
        try{
            tmp = Double.parseDouble(str);    
        }catch(Exception e) {
            return 0;
        }
        
        if(tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)tmp;
    }

}
