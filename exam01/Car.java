package ch09.sec07.exam01;

public class Car {
	private Tire tire1= new Tire(); 
	private Tire tire2= new Tire() {
	@Override
	public void roll() { //필드값
		System.out.println("익명 자식 TIre 객체 1이 굴러갑니다.");
	}
		//재정의메소드
	};//타이어객체 만들어서 타이어를 상속한 자식클래스를 실행부에 정의하고 이것을 객체로만들어서 tire2에 대입
	
	//메소드 생성
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	public void run2() {
		//변수선언
		Tire tire = new Tire() {
		 @Override
		 	public void roll() {
		 		// TODO Auto-generated method stub
			 System.out.println("익명 자식 TIre 객체 2가 굴러갑니다.");
		 	}	//타이어객체를 만들기보다 자식객체를 만들어서 대입하고싶다.
		};
		tire.roll();
	}
	public void run3(Tire tire) {
		tire.roll();
	}
}
