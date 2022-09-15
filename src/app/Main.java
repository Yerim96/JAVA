package app;

import pack1.A;
import pack2.B; //은닉된 
import pack3.C;

public class Main { //자파일 형태로 참조.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.method();
		
		B b = new B();
		b.method();
		
		C c = new C();
		c.method();
	}

}
