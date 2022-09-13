package ch08.sec05;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		
		rc= new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		rc.setMute(true); //선언은 인터페이스에 되어있지만 구현객체에 소속됨
		rc.setMute(false);
		System.out.println("현재볼륨"+rc.getVolume());
		
		rc= new Audio();
		rc.setVolume(7);
		rc.setMute(true);
		rc.setMute(false);
		System.out.println("현재볼륨"+ rc.getVolume());
	}

}
