package com.accuship.demo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BufferedWriterDemo {

	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("buf.txt");//create a stream
			BufferedWriter bw = new BufferedWriter(fw);//put stream into buffer
				) {
			bw.write("Str");//write into memory
			bw.newLine(); // start a new line
			bw.flush(); // refresh memory into file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void oldWay() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("buf.txt");//create a stream
			bw = new BufferedWriter(fw);//put stream into buffer
			bw.write("Str");//write into memory
			bw.newLine(); // start a new line
			bw.flush(); // refresh memory into file
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(bw != null) {
						try {
							bw.close(); // in fact, close bw is just closing fw
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		}
	}

}
