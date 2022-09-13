package ch08.sec02;

public class RemoteControlExample {
	public static void main(String[] args) {
		
		RemoteControl rc; //변수선언
		rc= new Television(); //rc를 가지고 Television객체를 사용할수있도록하겠다.
		
		rc.turnOn();//인터페이스를통해 메소드 선언
		
		rc = new Audio();
		rc.turnOn();
	}
}
