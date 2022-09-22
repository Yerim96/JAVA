package ch14.sec06.exam01;

public class SynchronizedExample {

	public static void main(String[] args) {
		//공유객체생성
		Calculator calculator = new Calculator();
		
				//각각의 스레드 생성
		User1Thread user1Thread = new User1Thread();
		//유저1내부에서 사용가능하도록 매개변수
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		//calculator를 각각 안쪽의 스레드에 넣어줌
		User1Thread2 user1Thread2 = new User1Thread2();
		//유저1내부에서 사용가능하도록 매개변수
		user1Thread2.setCalculator(calculator);
		user1Thread2.start();
	}

}
