package ch14.sec03.exam03;

import java.awt.Toolkit;

public class PrintThread extends Thread{
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

