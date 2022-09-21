package ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//작업1(메인 스레드)
		//Thread thread = new Thread(new Runnable());//인터페이스는 객체 못만들어서 말안되는코드
		
		Thread thread = new Thread() {//생성자호출처럼보이지만 자식클래스로 익명 생성
			@Override
			public void run() {
				Toolkit toolkit =Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		
		thread.start();
		
		
		
		
		//작업2
		/*for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		Thread thread2 = new PrintThread();
		thread2.start();
	}
}
