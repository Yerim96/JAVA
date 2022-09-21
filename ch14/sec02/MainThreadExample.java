package ch14.sec02;

public class MainThreadExample {

	public static void main(String[] args) {
	System.out.println("시작"); //실행흐름=스레드 실행
	Thread currThread= null; //현제실행하는 스레드객체의 참조 얻기
	System.out.print(currThread.getName());
	System.out.print("종료");
	}

}
