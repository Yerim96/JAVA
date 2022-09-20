package ch12.sec08;

import java.text.*;
import java.util.*;

public class DateExample {
	//현재 날짜를 문자열로 얻기. toString보다 SimpleDateFormat 클래스와 사용
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.print(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd HH:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);

	}

}
