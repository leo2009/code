package com.accuship.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {
	
	public static void main(String[] args) {
		file_str(true);
	}

    public static void file_str(boolean flag){ 
        String text1= "last summber ,I went to the italy"; 
        String url = "C:\\test\\test.log";
        int wordNO = 0;
        File file_one = new File(url); 
        Scanner sc= null; 
        if(flag){ 
            try { 
                sc =new Scanner(file_one); 
                sc.useDelimiter("\\W+");
            } catch (FileNotFoundException e) { 
                e.printStackTrace(); 
            } 
        }else{ 
            sc=new Scanner(text1); 
        } 
        System.out.println("title..........." + sc.delimiter());
        while(sc.hasNext()) {
        	wordNO++;
        	System.out.println(wordNO + ": " + sc.next()); 
        }
        sc.close(); 
    }
    
    
    public static void reg_str(){ 
        String text1= "last summber 23 ,I went to 555 the italy 4 "; 
        Scanner sc = new Scanner(text1).useDelimiter("\\D\\s*"); 
        while(sc.hasNext()){ 
                System.out.println(sc.next());   
        } 
        sc.close(); 
    } 
}
