package ch15.sec03.exam03;

import java.util.*;
public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		set.add("jsp");
		set.add("spring");
		
		Iterator<String> iterator= set.iterator();
		while(iterator.hasNext()){
			String element = iterator.next();
			System.out.println(element);
			if(element.equals("jsp")) {
				iterator.remove();
			}
		}

	System.out.println();
	
	set.remove("jdbc");
	
	for(String element : set) {
	System.out.println(element);
		

	}
	}
}
