package com.accuship.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Map: 
 * 		Hashtable: not allow null key, null value, thread safe
 * 		HashMap: allow null key, null value, thread not safe
 * 		TreeMap: thread not safe, sort map key
 * 
 * 1.add
 * 		V put(K key,V value) V-> type of value
 * 		put(Map)
 * 2.r
 * 		get(key)
 * 		size()
 * 		Collection<V> values()
 * 		
 * 		Set<Map.Entry<k,v> entrySet()  : Map.Entry: equals, getKey, getValue, hasCode, setValue
 * 		Set<K> keySet()
 * 3.determine
 * 		containsValue(obj)
 * 		containsKey(obj)
 * 		isEmpty()
 * 4.d
 * 		clear()
 * 		remove(key)
 * 
 */

public class MapDemo {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("1", "leo1");
		m.put("2", "leo2");
		m.put("3", "leo3");
		m.put("4", null);
		
		
		Collection<String> col = m.values();
		System.out.println("title..........." + col);
		
	}
	
	//java8 loop through
	public static void loop(Map<String, String> m) {
		m.forEach((k,v) -> System.out.println("k is" + k + " v is " +v)); 
	}
	
	//old way
	public static void oldLoop(Map<String, String> m ) {
		Set<Entry<String, String>> set = m.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while(it.hasNext()) {
			Entry<String, String> entry = it.next();
			System.out.println("k is" + entry.getKey() + " v is " + entry.getValue());
		}
	}
	

}
