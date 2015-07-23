package com.accuship.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Demo {

	public static void main(String[] args) {

	}
	
	public static void forWithIndex() {
		//before
		for (int i = 0 ; i < 10000 ; i++) {
		  System.out.print(i);
		}
		
		//after : intstream method: average(), boxed() ..
		IntStream.range(0, 10_000).forEach(i -> System.out.print(i));
		IntStream.rangeClosed(0, 9_999).forEach(i -> System.out.print(i));
	}
	
	public static void forOnCollection() {
		List<String> names = Arrays.asList("1", "2", "3");
		//old
		for (String name : names) {
		  System.out.println(name);
		}

		//new
		names.forEach(name -> System.out.println(name));
	}
	
	public static void arrayToStream() 	{
		//old
		List<String> list = Arrays.asList("1", "2", "3");
		list.contains("3");

		//new
		Stream.of("1", "2", "3").anyMatch("3"::equals);

		//not as good
		Arrays.asList("1", "2", "3").stream().anyMatch("3"::equals);

		//Arrays has new stream(), but not varargs
		// can't use Stream<String> t = Arrays.stream("1", "2", "3");
		String[] array = new String[] { "1", "2", "3" };
		Stream<String> s = Arrays.stream(array);
		int[] dimensions = new int[] { 1, 2, 3 };
		IntStream is = Arrays.stream(dimensions);
		
		//note: new feature -> Stream is interface, 
		//of() is interface static method. don't need 's' class like Collections
	}
	
	public static void stringJoin() {
		
		List<String> items = Arrays.asList("1", "2", "3");

		//java8
		String.join(":", items);

		//if it's not String, use Collectors.joining
		Stream.of("1", "2", null, "3")
		      .map(Objects::toString)
		      .collect(Collectors.joining(":"));
		
	}
	
	public static void mapLazyInit() {
		Map<String, Integer> vote = new HashMap<>();
		/*
		//old
		if (!vote.containsKey("John")) {
		  vote.put("John", dao.countVote("John"));
		}

		//new
		vote.computeIfAbsent("John", name -> dao.countVote(name));
		*/
		
		//note: dao.countVote is to query database which is resource consuming method, it's better
		// to lazy init in map. Map.computeIfAbsent() could do it.
	}
	
	public static void multiMapLazyInit() {
		Map<String, List<String>> albums = new HashMap<>();

		//old
		List<String> tracks = albums.get("Thriller");
		if (tracks == null) {
		  albums.put("Thriller", tracks = new ArrayList<>());
		}
		tracks.add("Billie Jean");

		//new
		//note: computeIfabset(key, function) return the value
		albums.computeIfAbsent("Thriller", tracks1 -> new ArrayList<>())
		      .add("Billie Jean");
	}
	
	public static void sortList() {
		List<String> data = Arrays.asList("1", "2","3");

		//old
		Collections.sort(data, (a, b) -> a.compareToIgnoreCase(b));

		//new
		data.sort((a, b) -> a.compareToIgnoreCase(b));
		
	}
	
	public static void sortMapByValue() {
		
//	     {'John':88, 'Mary':92, 'Bob':80}
	Map<String, Integer> scoreByName = new HashMap<String, Integer>();

	//sort by score dsc
	Map<String, Integer> topScoreByName = 
	  scoreByName.entrySet()  // convert to entry
	             .stream()
	             .sorted(Entry.<String, Integer>comparingByValue().reversed())
	             .collect(Collectors.toMap(Entry::getKey,
	                                       Entry::getValue,
	                                       (oldScore, newScore) -> newScore,
	                                       LinkedHashMap::new));
	                                       
	// result is {'Mary':92, 'John':88, 'Bob':80}
	//note: Entry . before<>, Entry.comparingByValue(), comparingByKey() return Comparator
	//Comparator.reversed(), naturalOrder() nullsFirst() .....
		
	}
	
	public static void doubleColonOperator() {
		/*
		Math::max ...means... (a, b)->Math.max(a, b)
		String::startWith ...means... (s1, s2)->s1.startWith(s2)
		s::isEmpty ...means... ()->s.isEmpty()
		*/ 
	}

}
