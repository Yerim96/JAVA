package ch12.sec03.exam03;
//객체 문자 정보 클래스명@16진수해시코드
public class ToStringExample {

	public static void main(String[] args) {
		SmartPhone myphone = new SmartPhone("삼성전자","안드로이드");
		
		String strObj= myphone.toString();
		System.out.println(strObj);
		
		
		System.out.println(myphone);
		

	}

}
