package ch14.sec06.exam01;

public class Calculator {
	//공유클래스
	private int memory; //필드선언

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) { //어떤 스레드가 오든 먼저오는놈의 setMemory를 처리.
		this.memory = memory;
		try {
			Thread.sleep(2000);//2초동안 정지
			}catch(Exception e) {}
		System.out.println(Thread.currentThread().getName() +":"+this.memory);
	}

	
}
