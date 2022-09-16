package ch11.sec06;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예금액"+ account.getBalance());
		
		try {
		account.withdraw(30000); //일반예외이기떄문에 컴파일시 체크됨. 무조건 try있어야함.InsufficientException 예외발생 가능성있음.
		}catch(InsufficientException e) {
			String message=e.getMessage();
			System.out.println(message);
		}
		System.out.println("예금액"+ account.getBalance()); //마지막으로 어떤 값 가지는지 확인
		}

}
