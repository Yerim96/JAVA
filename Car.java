package ch06.sec10;

public class Car {
	int speed;
	
	void run() {
		System.out.println(speed+"으로 달립니다.");
	}
	
	static void simulate() {//정적 메서드
		Car mycar =new Car();
		
		mycar.speed=200;
		mycar.run();
	}
	
	public static void main(String[] args) {
		simulate(); //main도 정적으로 선언되었기 때문에 static메서드 사용 가능.
		
		Car mycar = new Car();
		mycar.speed= 60;
		mycar.run();
		
		
	}
}
