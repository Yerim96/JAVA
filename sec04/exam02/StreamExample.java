package ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		String[] StrArray = {"홍길동","신용권","김미나"};
		Stream<String> strStream=Arrays.stream(StrArray);
		strStream.forEach(item->System.out.println(item+","));
		System.out.println();
		
		
		int[] intArray= {1,2,3,4,5};
		IntStream intStream =Arrays.stream(intArray);
		intStream.forEach(item-> System.out.print(item+","));
		System.out.println();

	}

}
