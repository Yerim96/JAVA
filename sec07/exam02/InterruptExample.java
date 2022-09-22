package ch14.sec07.exam02;

public class InterruptExample {

	public static void main(String[] args) {

		Thread thread = new PrintThread(); //Thread가 부모클래스이기 때문에 PrintThread사용가능
	
		thread.start(); //실행대기
		try {
			Thread.sleep(3000); //메인스레드 3초 정지
		}catch (InterruptedException e) {
			
		}
		thread.interrupt();//일시정지상태를 방해. 그러나 PrintTread 클래스에서 일시정지 메소드 없어서 계속 실행이 됨.
	}

}
