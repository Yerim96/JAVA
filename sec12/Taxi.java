package ch08.sec12;

public class Taxi implements Vehicle{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//구현객채에서 인터페이스에 선언된 추상메서드를 오버라이딩해준다.
		System.out.println("택시가 달립니다.");
	}
}
