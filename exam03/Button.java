package ch09.sec07.exam03;

public class Button {
	//필드
	private ClickListener clickListerner;//인스턴스변수선언
	
	public void setClickListener(ClickListener clickListerner) {
		//외부에서 구현객체를 받아서 필드에 저장하겠다.
		this.clickListerner= clickListerner;
	}
	public void click() {
		//버튼클릭을 처리하는 방법
		clickListerner.onClick(); 
	}
	//생성자
	//메소드
	//중첩클래스
	//중첩인터페이스
	public static interface ClickListener{
		//버튼객체 필요없이 인터페이스 사용하기 위해 static
		public void onClick(); //모든리스너는 onclik사용//추상메소드. 실행부는 구현객체가 가지고있ㅇ므
		
	}
}
