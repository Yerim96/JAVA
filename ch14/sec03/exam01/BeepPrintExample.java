package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//작업1(메인 스레드)
		Toolkit toolkit =Toolkit.getDefaultToolkit(); //정적메소드를통해 리턴값 얻겠다.
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		//작업1
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
