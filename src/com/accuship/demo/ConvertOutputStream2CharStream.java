package com.accuship.demo;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class ConvertOutputStream2CharStream {

	public static void main(String[] args) {
		try(OutputStream out = System.out; // print to console
			OutputStreamWriter ow = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(ow)){
			
			String line = "test";
			bw.write(line);
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
