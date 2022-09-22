package ch14.sec06.exam01;

public class User1Thread2 extends Thread{
	private Calculator calculator;
	
	public User1Thread2() {
		//스레드 이름 바꾸기
		setName("User2Thread");
	}
	public void setCalculator(Calculator calculator) {
		this.calculator =  calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
