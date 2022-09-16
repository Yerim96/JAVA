package ch11.sec03.exam01;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
	String[] array= {"100","1oo"};
	
	for(int i= 0; i<=2; i++) {
		try{
			System.out.println(array[i]); //예외발생1
		int value = Integer.parseInt(array[i]); //예외발생2
		
		}catch(NumberFormatException e){
			System.out.println("숫자로 변환할수 없는 항목이 있습니다. 확인해주십셔"); //예외발생2 출력
		}catch(Exception e) {
			System.out.println("항목수가 부족합니다. 다시 확인해주세요"); //예외발생1 출력
		
		}
	}

	}
}
