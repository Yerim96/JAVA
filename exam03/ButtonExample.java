package ch09.sec07.exam03;
import ch09.sec07.exam03.Button;
public class ButtonExample {//버튼실행하는 클래스

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//버튼객체 생성
		Button btnOk= new Button();
		Button btnCancel = new Button();
	

		//버튼 객체에 클릭 이벤트 처리 객체 설정
		btnOk.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("ok버튼크릭");
			}
		});
		btnCancel.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("cancle 버튼크릭");
			}
		}); 

		btnOk.click();
		btnCancel.click();
	}

}
