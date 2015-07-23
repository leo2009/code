package com.accuship.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IOTest {

	public static void main(String[] args) throws IOException{
		File f = new File("C:\\Users\\leo.zhou\\Desktop\\test3.txt");
//		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		if(f.exists()){
			
		}else{
			f.getParentFile().mkdirs();
			f.createNewFile();
		}
		
		try {
			System.out.print(f.getPath());
//			br = new BufferedReader(new FileReader("C:\\Users\\leo.zhou\\Desktop\\txt\\test.txt"));
			fw = new FileWriter(f.getPath());
			bw = new BufferedWriter(fw);
//			fw = new FileWriter("C:\\Users\\leo.zhou\\Desktop\\txt\\test1.txt");
			String s = "test";
//			for(int i=0; i<5; i++) {
//				bw.write(s+"\t" + i);
//				bw.newLine();
//				bw.flush();
//			}
//			while((s=br.readLine())!=null){
////				System.out.println(s);
////				fw.write(c);
//				bw.write(s+"\r\n");
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
//			br.close();
			bw.close();
			fw.close();
			
		}
		f.delete();

				
//	      int rowNum = 0;
//	      ResultSetMetaData meta = rs.getMetaData();
//	      int colCount = meta.getColumnCount();
//
//	      Row header = sh.createRow(rowNum++);
//	      for (int c = 1; c <= colCount; c++) {
//	        Cell cell = header.createCell(c - 1);
//	        cell.setCellValue(meta.getColumnLabel(c));
//	      }
//
//	      while (rs.next()) {
//	        if (canceled) {
//	          cleanup();
//	          return null;
//	        }
//	        Row row = sh.createRow(rowNum++);
//	        for (int c = 1; c <= colCount; c++) {
//	          Cell cell = row.createCell(c - 1);
//	          cell.setCellValue(rs.getString(c));
//	        }

	}

}
