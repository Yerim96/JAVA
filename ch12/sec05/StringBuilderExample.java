package ch12.sec05;

public class StringBuilderExample {
	//연이어서 다른 메소드를 호출할수있는 메소드 체이닝 패턴을 사용할 수 있다.
	public static void main(String[] args) {
		String data = new StringBuilder()
		.append("DEF") //세미클론 생략
		.insert(0,"ABC")
		.delete(3,4)
		.toString();
		
		System.out.println(data);
		
	}

}
