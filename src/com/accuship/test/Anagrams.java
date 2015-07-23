package com.accuship.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

	public static void main(String[] args) {
//		System.out.println("bolean..........." + isAnagram("lint", "inlt"));
//		System.out.println("title..........." + anagrams(new String[] {"nozzle","punjabi","waterlogged","imprison","onzzel","numismatists","sultans","rambles","deprecating","aware","outfield","marlborough","guardrooms","roast","wattage","shortcuts","confidential","reprint","foxtrot","dispossession","floodgate","unfriendliest","semimonthlies","dwellers","walkways","wastrels","dippers","engrossing","undertakings","unforeseen","oscilloscopes","pioneers","geller","neglects","cultivates","mantegna","elicit","couriered","shielded","shrew","heartening","lucks","teammates","jewishness","documentaries","subliming","sultan","redo","recopy","flippancy","rothko","conductor","e","carolingian","outmanoeuvres","gewgaw","saki","sarah","snooping","hakka","highness","mewling","spender","blockhead","detonated","cognac","congaing","prissy","loathes","bluebell","involuntary","aping","sadly","jiving","buffalo","chided","instalment","boon","ashikaga","enigmas","recommenced","snell","parsley","buns","abracadabra","forewomen","persecuted","carsick","janitorial","neonate","expeditiously","porterhouse"}));
//		System.out.println("title..........." + longestCommonPrefix(new String[] {"abc","abcd","","","ac"}));
		System.out.println("1..........." + anagrams2(new String[] {"abc","abcd","","","ac"}));
	}
	
    public static List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<String>();
        List<String> tmp = new ArrayList<String>(Arrays.asList(strs));
        for(int i=0; i<strs.length; i++) {
        	for(int j=0; j<strs.length; j++) {
        		if(i != j) {
        			if(isAnagram(strs[i], strs[j])) {
        				res.add(strs[i]);
        				break;
        			}
        		}
        	}
        }
        return res;
    }
    
    public static List<String> anagrams2(String[] strs) {
    	Map<String, List<String>> m = getMap(strs);
    	List<String> res = new ArrayList<String>();
    	m.forEach((k,v) -> {
    		if(v.size()>1) res.addAll(v);
    	});
    	
    	Collection<List<String>> ls = m.values();
    	Iterator<List<String>> it = ls.iterator();
    	while(it.hasNext()) {
    		List<String> l = it.next();
    		if(l.size()>1) res.addAll(l);
    	}
    	return res;
    }
    
    public static Map<String, List<String>> getMap(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        char[] chars = null;
        for(String s : strs) {
            chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(m.get(key) == null) {
                m.put(key, new ArrayList<String>());
            }
            m.get(key).add(s);
        }
        return m;
    }
    
    public static boolean isAnagram(String a, String b) {
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
    
    
    public static String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        int count = 0;
        Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
        	
        });
        for (int i = 0; i < strs[0].length(); i++) {
            if (!isCommonLetter(strs[0].charAt(i), i, strs)) {
                break;
            }
            count++;
        }
        return count==0 ? "" : strs[0].substring(0, count);
    }

    public static boolean isCommonLetter(char c, int index, String[] strs) {
        for (String s : strs){
            if (c != s.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    

}
