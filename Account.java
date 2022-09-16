package ch11.sec06;

public class Account {
	private long balance; //private이라 필드를 읽을수있도록 게터필요함.
	private String owner;
	
	public Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {//예외발생조건
		balance += money; 
	}
	
	public void withdraw(int money) throws InsufficientException {//호출한쪽에서
		if(balance < money) {
			throw new InsufficientException("잔고 부족" + (money-balance)+ "모자람");
			//예외발생 이유
		}
		 balance -=money;
		
	}
}

