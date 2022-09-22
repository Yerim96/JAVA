package ch14.sec08;

public class DaemonExample {
	public static void main(String[] args) {
		
		AutoSaveThread thread = new AutoSaveThread();
		thread.setDaemon(true);
		thread.start(); //스타트하기 전에
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			
		}
		//메인이 3초동안 종료됨.
		System.out.print("메인스레드 종료");
	}
}
