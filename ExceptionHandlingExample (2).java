package ch11.sec03.exam03;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
	String[] array= {"10","1oo",null,"2009"};
	
	for(int i= 0; i<=4; i++) {
		try{
			System.out.println(array[i].length()); //예외발생1
		int value = Integer.parseInt(array[i]); //예외발생2
		
		}catch(NumberFormatException e){
			System.out.println("숫자로 변환할수 없는 항목이 있습니다. 확인해주십셔"); //예외발생2 출력
		}catch(NullPointerException |ArrayIndexOutOfBoundsException e) {//예외두개처리
			System.out.println("문자열 없거나 항목수가 부족합니다."); //예외발생1 출력
		}catch(Exception e) {//예외두개처리
			System.out.println("예상치못한 예외발생"); //예외발생1 출력
		}
	}

	}
}
