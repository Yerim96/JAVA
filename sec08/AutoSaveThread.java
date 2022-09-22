package ch14.sec08;

public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용을 저장함");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10000);
			}catch(InterruptedException e) {
				break;
			}
			save();
	}
	System.out.println("자동저장스레드를안전하게종료함");
}
	
	
}
