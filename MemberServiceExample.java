package ch07.sec04;

public class MemberServiceExample {

	public static void main(String[] args) {

		MemberService memberService = new MemberService(); // 객체 생성
		boolean result = memberService.login("hong","12345"); //boolean 타입으로 값 받기. 객체의 매서드 login사용하기
		
		if(result) {
			System.out.println("로그인되었습니다.");
			memberService.logout("hong");
			
		}else {
			System.out.println("id또는 password가 옳지 않습니다.");
		}
	}

}
