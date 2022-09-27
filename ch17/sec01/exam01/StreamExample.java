package ch17.sec01.exam01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("홍길동");
		set.add("김길동");
		set.add("감자바");
		
		//외부반복자 이용
		for(String item : set){
			System.out.println(item);
		}
		
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			System.out.println(item);
		}
		
		//내부 반복자 이용
		Stream<String> stream = set.stream();
		stream.forEach((item)->{
			System.out.println(item);
		}); //처리방법을 스트림으로 보냄(처리방식을 스트림에 넣어줌).가지고 와서 처리하는 방식 xㅌ
	//흘러가는 요소가 t자리에 들어옴.

		
		stream =set.stream();
		stream.forEach((item)->System.out.println(item));
		//스트림은 한번 사용하면 재사용 못함. 또 다른 스트림을 얻어서 사용해야함.
	}

}
