package com.accuship.test;

public class BitSwap {

	public static void main(String[] args) {
		System.out.println("title..........." + bitSwapRequired(1,-1));
	}
	
    public static int bitSwapRequired(int a, int b) {
        String m = format(a);
        String n = format(b);
        
        System.out.println("title..........." + m);
        System.out.println("title..........." + n);
        int count = 0;
        for(int i=0; i<m.length(); i++){
            if(m.charAt(i) != n.charAt(i)) count++;
        }
        return count;
        
        
    }
    
    public static String format(int	num) {
    	String str = Integer.toBinaryString(num);
    	if(num > -1) {
    		int count = 32-str.length();
    		for(int i=0; i<count; i++) {
    			str = "0"+str;
    		}
    	}
    	return str;
    }

}
