package ch14.sec07.exam02;

public class PrintThread extends Thread{
	@Override
	public void run() {//Thread가 가지고 있는 멤버
	//try {
		while (true) {
			//Thread.sleep(1);
		System.out.println("실행중...");
		if(isInterrupted()) {
			break;
		//Thread.sleep(1); //짧은시간이 정지상태라도 방해가 들어옴.
		//}
	}//catch (Exception e) {
		//System.out.println(e.getMessage()); //리소스 정리할 기회를 줌.
	}
	System.out.println("리소스 정리");
	System.out.println("실행 종료");
	}
}
