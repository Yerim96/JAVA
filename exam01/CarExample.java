package ch09.sec07.exam01;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car(); //변수선언 객체만들어대입.
		
		car.run1();
		
		car.run2();
		car.run3(new Tire() {
			 @Override
			public void roll() {
				 System.out.println("익명 자식 TIre 객체 3가 굴러갑니다.");
			}
		});
	}

}
