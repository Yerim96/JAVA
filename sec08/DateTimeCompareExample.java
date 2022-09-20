package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//날짜와 시간비교 
public class DateTimeCompareExample {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd aHH:mm:ss"); //DateTimeFormatter 는 날짜와 시간을 문자열패턴으로 전환
		
		LocalDateTime startDateTime =LocalDateTime.of(2021, 1,1,0,0,0);
		System.out.println("시작일: "+startDateTime.format(dtf));
		
		LocalDateTime endDateTime=LocalDateTime.of(2021, 12,31,0,0,0);
		System.out.println("시작일: "+startDateTime.format(dtf));
		
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("진행중입니다.");
		}else if(startDateTime.isBefore(endDateTime)) {
			System.out.println("종료합니다");
			
		}else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("종료헀습ㄴ디ㅏ");
		}
		
		long remainYear = startDateTime.until(endDateTime,ChronoUnit.YEARS);
		long remainMONTHS = startDateTime.until(endDateTime,ChronoUnit.MONTHS);
		long remainDAYS = startDateTime.until(endDateTime,ChronoUnit.DAYS);
		long remainHOURS = startDateTime.until(endDateTime,ChronoUnit.HOURS);
		long remainMINUTES = startDateTime.until(endDateTime,ChronoUnit.MINUTES);
		long remainSECONDS = startDateTime.until(endDateTime,ChronoUnit.SECONDS);
		
		System.out.println("남은 해" + remainYear);
		System.out.println("남은 월" + remainMONTHS);
		System.out.println("남은 일" + remainDAYS);
		System.out.println("남은 시간" + remainHOURS);
		System.out.println("남은 분" + remainMINUTES );
		System.out.println("남은 초" + remainSECONDS);
		}

}
