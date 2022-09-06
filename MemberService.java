package ch07.sec04;

public class MemberService {
	//login 메소드
	//logout 메소드
	
	boolean login(String id , String password) {
		if(id.equals("hong")&&password.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	
	void logout(String a) {
		System.out.println("로그아웃되었습니다.");
	}

}
