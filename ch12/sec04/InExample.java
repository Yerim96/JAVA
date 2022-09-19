package ch12.sec04;

public class InExample {
	//키보드 입력
	public static void main(String[] args) throws Exception {
		int speed=0; //실행클래스에서의 변수선언이다. 필드가 아님!
		int keyCode =0;
		
		while(true) {
			if(keyCode != 13 && keyCode!= 10) {
				if(keyCode ==49) {
					speed++;
				}else if(keyCode==50) {
					speed--;
				}else if(keyCode ==51) {
					break;
				}
				System.out.println("--------------");
				System.out.println("1증속  2감속  3 중지");
				System.out.println("--------------");
				System.out.println("현재속도="+speed);
				System.out.println("선택: ");
			}
			keyCode= System.in.read();
		}
		System.out.println("프로그램종료");
	}
}
