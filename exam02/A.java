package ch09.sec02.exam02;

public class A {
	class B{
		int field1 =1;
		
		static int field2= 2;
		
		B(){ //생성자
			System.out.println("B 생성자 실행");
		}
	
		void method() { //메소드
			System.out.println("B 메소드1 실행");
		}
		static void method2() {
			System.out.println("B 메소드2 싱행");
		}
			
		}
	

	void useB() { 
		B b = new B();
		System.out.println(b.field1);
		b.method();
		
		System.out.println(B.field2);
		B.method2();
	}
	}
}
