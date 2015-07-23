package com.accuship.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;


/*
 * connect all the stream together 
 * 
 * not piped: use pipedInputStream and PipedOutputStream to pipe
 */
public class SequenceStreamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		
		v.add(new FileInputStream("1.txt"));
		v.add(new FileInputStream("2.txt"));
		v.add(new FileInputStream("3.txt"));
		
		Enumeration<FileInputStream> en = v.elements();
		
		SequenceInputStream sis = new SequenceInputStream(en);
		BufferedInputStream bs = new BufferedInputStream(sis);
		int by = 0;
		try(PrintWriter pw = new PrintWriter("buf.txt");){
			while((by=bs.read()) != -1) {
				pw.print(by);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
