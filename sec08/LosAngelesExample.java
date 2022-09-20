package ch12.sec08;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {
	//캘린더 클랫 오버로딩된 다른 getInstance()메소드 이용하
	public static void main(String[] args) {
		TimeZone timezone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar now = Calendar.getInstance(timezone);
		

		int amPm = now.get(Calendar.AM_PM);
		String strAmPm=null;
		if(amPm ==Calendar.AM) {
			strAmPm="오전";
		}else {
			strAmPm="오후";
		}
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.print(strAmPm +"년 ");
		System.out.print(hour +"월 ");
		System.out.println(minute +"일 ");
		System.out.println(second +"요일");
		
	}

}
