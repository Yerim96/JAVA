package ch09.sec03.exam01;

public class A {
	static class B{
		int field=1;
		
		static int field2 =2 ;
		
		B(){
			System.out.println("b 생성자 실행");
		}
		
		void method1() {
			System.out.println("b 메소드 실행");
		}
	}
}
