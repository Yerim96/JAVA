package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
	public static void printLength(String data) {//data안들어오면 컴파일오류가남.
		try{
		int result = data.length(); //예외발생코드
		System.out.println("문자 수 :"+result); //실행x 예외발생순간부터 밑 코드는 건나뜀.
		}catch(NullPointerException e) { //예외발생시 잡는다. e로 예외객체의 데이터를 이용가능
			System.out.println(e.getMessage()); //예외객체로가서 get메소드를 호출함. 메소드안에 이유 있음. 이유 간단하게.
			//System.out.println(e.toString()); //예외의 종류와 예외의 사유까지 리턴해줌. getMessage와의 차이? 예외의 종류까지 알려줌.
			//e.printStackTrace(); //예외가 어디서 발생되었는지 추적함. 내부적으로 출력문이 있기에 System.안쓰고 호출만 가능 예외처리코드아니고, 예외의 정보를 출력만해줌.
		} finally {
			System.out.println("마무리 실행\n"); //파이널리는 예외여부에 관계없이 한번 실행.
		}
	}


	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");

	}

}
