package ch12.sec08;

import java.util.Calendar;

public class CalendarExample {
	//캘린더에 정의된 상수를 주면 상수가 의미하는 값 리턴
	public static void main(String[] args) {
		Calendar now =Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.YEAR);
		int day = now.get(Calendar.YEAR);
		
		int week = now.get(Calendar.DAY_OF_MONTH);
		
		String strWeek= null;
		
		switch(week) {
		case Calendar.MONDAY: strWeek ="월 "; break;
		case Calendar.TUESDAY: strWeek ="화 "; break;
		case Calendar.WEDNESDAY: strWeek ="수 "; break;
		case Calendar.THURSDAY: strWeek ="목 "; break;
		case Calendar.FRIDAY: strWeek ="굼 "; break;
		case Calendar.SATURDAY: strWeek ="토 "; break;
		default:				strWeek="일";
	 
		}
		
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
		
		System.out.print(year +"년 ");
		System.out.print(month +"월 ");
		System.out.println(day +"일 ");
		System.out.println(strWeek +"요일");
		System.out.println(strAmPm +"");
		System.out.println(hour +"시");
		System.out.println(minute +"분");
		System.out.println(second +"초");
	}

}
