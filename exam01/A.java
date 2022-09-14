package ch09.sec02.exam01;

public class A {
	int field;
	B field2; //b클래스 타입으로 선언 가능.
	
	A(){ //생성자
	B b = new B();
	b.methodB();
	}
	
	void methodA() {
		B b = new B();
		b.methodB();
	}
	public class B{
		public void methodB() {
			System.out.println("메소드 b 실행");
			
			}
		}
	}
	


