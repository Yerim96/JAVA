package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {

	public static void main(String[] args) {
		int[] intarr = {2,4,6};
		
		boolean result = Arrays.stream(intarr)
				.allMatch(a->a%2==0);
				System.out.print("모두 2의 배수인가?"+result);
				
		result = Arrays.stream(intarr)
				.anyMatch(a-> a%3==0);
		System.out.print("하나라도 3의 배수인가?"+result);
		
		result = Arrays.stream(intarr)
				.noneMatch(a-> a%3==0);
		System.out.print("3의 배수가 없는가?"+result);

	}

}
