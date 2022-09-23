package ch15.sec03.exam01;

import java.util.*;
public class HashSetExample {

	public static void main(String[] args) {
		
		Set<Member> set = new HashSet<Member>();
		

		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동", 30));
		
		int size = set.size();
		System.out.println("총 객체 수"+ size);
		

	}

}
