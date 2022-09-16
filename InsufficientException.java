package ch11.sec06;

public class InsufficientException extends Exception { //예외발생 메소드 만들기 사용자정의
	public InsufficientException() {} 
	public InsufficientException(String message) {
		super(message);
	}
}
