package ch07.sec09;

public class Student extends Person {
	public int studentNo; //Person의 자식클래스.
						  //필드 선언
	public Student(String name, int studentNo) { //생성자에 매개변수 선언
		super(name); //super로 부모의 name 데이터? 가져오기
		this.studentNo = studentNo; //this로 
	}
	
	public void study() {
		System.out.println("공부를 합니다.");
	}
}
