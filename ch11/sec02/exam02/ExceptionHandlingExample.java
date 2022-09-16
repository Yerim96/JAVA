package ch11.sec02.exam02;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		try{
			Class.forName("java.lang.Strig");//정적메소드 forName을 호출하겠다. 이름으로 되어있는 클래스가 있는지 확인. 있다면 메모리에 저장.자바의 랭클레스에 있는 클래스.
		System.out.println("주어진 클래스가 있습니다.");
		} catch(ClassNotFoundException e) {//괄호사이에 어떤예외를 처리할것인지 작성.
			System.out.println("주어진 클래스는 없습니다.(잘못된 클래스가 저장되었다)");
		}
		System.out.println();
		try{Class.forName("java.lang.Strig2");//없는 클래스라 오류.
		System.out.println("주어진 클래스가 있습니다.");
		} catch(ClassNotFoundException e) {//괄호사이에 어떤예외를 처리할것인지 작성.
			System.out.println("주어진 클래스는 없습니다.(잘못된 클래스가 저장되었다)");
			e.printStackTrace();
		}
		
	}

}
