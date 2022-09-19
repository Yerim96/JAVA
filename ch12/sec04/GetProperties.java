package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetProperties {
	//시스템 프로퍼티 읽기 시스템 프로퍼티란 자바 프로그램이 시작될때 자동 설정되는 시스템의 속성을 말한다. 예를들어 운영체제 종류 및 사용자 정보,자바 버전등의 기본 사양 정보가 해당한다.
	public static void main(String[] args) {
		String osName=System.getProperty("os.name");
		String userName=System.getProperty("user.name");
		String userHame=System.getProperty("user.home");
		
		System.out.println("------------------------");
		System.out.println("key : value");
		System.out.println("------------------------");
		Properties props=System.getProperties();
		Set keys=props.keySet();
		
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s:%s\n",key,value);
		}
		

	}

}
