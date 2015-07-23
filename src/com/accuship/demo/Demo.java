package com.accuship.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

	public static void main(String[] args) {
        String url = "C:\\test\\test.log";
        File file_one = new File(url); 
        try(Scanner sc = new Scanner(file_one)){
            Map<String, Integer> m = getWord(sc);
//    		for(Map.Entry<String, Integer> en : m.entrySet()) {
//    			System.out.println(en.getKey() + "..........." + en.getValue());
//    		}
    		Set<Entry<String, Integer>>  ts = new TreeSet<Map.Entry<String,Integer>>(new EntryComparator());
    		ts.addAll(m.entrySet());

    		
    		System.out.println("resulst is ..........." + getResult(ts,3));
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        

	}
	
	public static Map<String, Integer> getWord(Scanner s) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		s.useDelimiter("\\W+");
		String word = null;
		while(s.hasNext()) {
			word = s.next();
			if(hm.get(word) != null) {
				hm.put(word, hm.get(word)+1);
			}else {
				hm.put(word, 1);
			}
		}
		return hm;
	}
	
	public static List<String> getResult(Set<Entry<String, Integer>> set, int rank) {
		//set is sorted by integer desc
		List<String> res = new ArrayList<String>();
		int counter = 0; //
		int appearanceTime = 0; // use this to compare if rank the same
		Entry<String, Integer> en = null;
		Iterator<Entry<String, Integer>> it = set.iterator();
		while(it.hasNext()) {
			en = it.next();
			if(en.getValue() != appearanceTime) { // != means not rank the same, rank counter +1
				appearanceTime = en.getValue();
				counter++;
				if(counter == rank) {
					res.add(en.getKey());
				}
			}else {
				if(counter == rank) {
					res.add(en.getKey());
				}
			}
		}
//		List<String> test = set.stream().filter((entry) -> entry.getValue())
		return res;
	}
	

}

class EntryComparator implements Comparator<Map.Entry<String,Integer>> {

	@Override
	public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
//		return e1.getValue().compareTo(e2.getValue());
		int res = e1.getValue().compareTo(e2.getValue());
		if(res == 0) {
			return e1.getKey().compareTo(e2.getKey());
		}
		return res;
	}

	
}
