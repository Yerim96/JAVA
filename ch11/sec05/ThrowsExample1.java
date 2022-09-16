package ch11.sec05;

public class ThrowsExample1 {

	public static void main(String[] args) throws ClassNotFoundException {			//main도 떠넘기기하면 jvm이 처리해야함. 
																				//jvm은 그냥 예외처리하고 끝냄.
		

			try{
				findClass();
			}catch(ClassNotFoundException e) {
				System.out.println("예외처리"+e.toString());
			}
			//메소드만 덜렁쓰면 예외처리안하면 왜 예외처리 안했냐고함.그래서 try에 넣어서 예외처리함.
			//메소드만 덜러쓰기 가능함.main도 떠넘기기!-> jvm이 처리해야함. main이 최후의 떠넘기기. 좋은코드 아님.
			//jvm은 그냥 예외처리하고 끝냄. 사실상 예외처리가 아니라 그냥 출력하고마는것. 
 
	}
	
	public static void findClass() throws ClassNotFoundException { //파인드클래스는 지가 예외처리하기 싫고 실행한쪽으로 던지고싶을때 throws사용
		Class.forName("java.lang.String2"); //넘겼으니 난 예외처리함 ㅇㅇ 오류안뜸 호출쪽에서 원인제공했으니 니가 처리해라.

		}

}
