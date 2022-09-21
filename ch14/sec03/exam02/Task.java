package ch14.sec03.exam02;

public class Task implements Runnable { //작은내용을 갖고있는 객체
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
