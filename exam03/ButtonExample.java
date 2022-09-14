package ch09.sec06.exam03;

public class ButtonExample {//버튼실행하는 클래스

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//버튼객체 생성
		Button btnOk= new Button();
		Button btnCancel = new Button();
	
		//리스너 처리객체로 이벤트 내용 정의 Button Click Event 처리객체 (Listener 객체) 처리클래스
		//명시적 클래스 선언
		
		class OkListener implements Button.ClickListener{
			//실제로 ok버튼이 눌렸을때 실행해야할 코드
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("ok 버튼을 클릭했습니다.");
			}
		} 
		
		class CancelListener implements Button.ClickListener{
			//실제로 ok버튼이 눌렸을때 실행해야할 코드
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("cancel 버튼을 클릭했습니다.");
			}
		}
		//버튼 객체에 클릭 이벤트 처리 객체 설정
		btnOk.setClickListener(new OkListener());
		btnCancel.setClickListener(new CancelListener());
		
		//버튼이 클릭되었을대
		btnOk.click();
		btnCancel.click();
	}

}
