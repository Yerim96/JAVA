package ch07.sec09;

public class Person { //부모 클래스
	public String name; //필드선언
	
	public Person(String name) {
		this.name= name;	//생성자 선언.
	}
	
	public void walk() { //반환값 없는 void 메서드
		System.out.println("걷습니다.");
	}
}
