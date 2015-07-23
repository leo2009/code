package com.accuship.demo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * printStream constructor:
 * file obj: file
 * string path: string
 * byte outString: outputStream
 * 
 * printWriter constructor:
 * file obj: file
 * string path: string
 * byte outStream: outputStream
 * char outStream: Writer
 * CONCLUDE: ALL STREAMS could be used by this Writer
 * 
 * method: println(stream [boolean autoFlush])
 * 
 */

public class PrintWriterDemo {

	public static void main(String[] args) {
		try(PrintWriter pw = new PrintWriter(new FileWriter("buf.txt"), true);// as long as arg it's a OUT STREAM, auto flush could be set true
//		    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buf.txt")), true) // more efficient
//			PrintWriter pw = new PrintWriter("buf.txt");// could NOT auto flush
				){
			String line = "test";
			while(line != null) {
				pw.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
