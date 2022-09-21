package ch14.sec03.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//작업1(메인 스레드)
		//Thread thread = new Thread(new Runnable());//인터페이스는 객체 못만들어서 말안되는코드
		//익명구현객체로 스레드생성
		Thread thread = new Thread(new Runnable() { //직접 생성자 생성
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
		
		});
		
		thread.start();
		
		
		
		
		//작업2
	/*	for(int i=0; i<20; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		
		//Runnable task = new Task(); 도 가능하다.
		Task task = new Task(); //따로 클래스를 명시적으로 만들어서 생성자와 매개값 줌.
		//따로 클래스를 명시적으로 만들면 재활용 가능해 좋다.
		Thread thread2 = new Thread(task);
		thread2.start(); 
	}
}
