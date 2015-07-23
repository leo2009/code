package com.accuship.demo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 3 things to consider before IO
 * 		1. src and dst
 * 				src: InputStream, Reader
 * 				dst: OutputStream, Writer
 * 		2. is data text
 * 				yes: char stream
 * 				no: byte stream
 * 		3. src and dst device
 * 				src: memory, hard disc, keyboard ( NOT sure yet,FileReader, system.in)
 * 				dst: memory, hard disc, console ( NOT sure yet,FileWriter, system.out)
 * 				
 */

public class BufferedReaderDemo {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader("buf.txt"); // create a stream
			BufferedReader br = new BufferedReader(fr); // put stream into buffer
				){
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println("title..........." + line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
