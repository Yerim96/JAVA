package ch16.sec04;

public class Person {
	public void action(Calcualble calcualble) {
		double result=calcualble.calc(10, 4); //리턴값을 받기위해 double 타입의 result 로 값을 받음.
		System.out.println("결과: "+result);
	}
}
