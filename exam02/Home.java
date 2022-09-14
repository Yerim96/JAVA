package ch09.sec07.exam02;

public class Home {
	//field
	private RemoteControl rc= new RemoteControl() {//필드의 초기값으로 원래 구현객체가 대입되어야하지만 명시적으로 클래스를 작성한 경우가 없다. 바로 익명구현객체를 선언
	public void turnOn() {//중괄호 사이에는 인터페이스가가지고있는 메소드를 재정의해야함.
		System.out.println("tv 킴");
	};
	
	public void turnOff() {
		System.out.println("tv 끔");
	};
	
	};

			//constructor
	//Method
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
	
	public void use2() {
		RemoteControl rc= new RemoteControl() {//변수선언. 필드 x 구현객체 대입해야하지만 없어서 바로 만들어 대입할것
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("에어컨끔");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("에어컨킴");
			}
			//변수선언. 필드 x 구현객체 대입해야하지만 없어서 바로 만들어 대입할것
		};
	rc.turnOn();
	rc.turnOff();
	}
	
	public void use3(RemoteControl rc) {//매개변수값은 호출할떄 주기 때문에 
		rc.turnOn();
		rc.turnOff();
	}

}
