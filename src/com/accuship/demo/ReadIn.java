package com.accuship.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * system.out: stdout : console
 * system.in: stdin: keyboard
 * system.in is inputStream, so convert it to char stream in order to use readLine
 */
public class ReadIn {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in; //get keyboard inputStream
		
		InputStreamReader ir = new InputStreamReader(in); // convert inputStream to char Stream
		
		BufferedReader br = new BufferedReader(ir); // put char Stream into buffer
		
		String line = null;
		while((line = br.readLine()) != null) {
			if("quit".equals(line))
				break;
			System.out.println("title..........." + line);
		}
		br.close();
		

	}

}
