package ch12.sec09;

import java.util.regex.Pattern;

public class PatternExample {
//정규표현식 클래스
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regExp="(02|010)-\\d{3,4}-\\d{4}";
		String data="010-123-4567";
		
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		}else {
			System.out.println("정규식과 일치x.");
		}
		
		regExp="\\w+@\\w+\\.\\w+(\\.\\w+)?";
		
		data="angle@mycompanycom";
		if(result) {
			System.out.println("정규식과 일치합니다.");
		}else {
			System.out.println("정규식과 일치x.");
		}
	}

}
