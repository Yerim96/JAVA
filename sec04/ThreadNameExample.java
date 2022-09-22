package ch14.sec04;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		for(int i=0; i<3; i++) {
			Thread threadA= new Thread() {
				@Override
				public void run() {
					System.out.println(getName() +"실행");
				}
			};
			threadA.start();
		}
		Thread charThread = new Thread() {
			@Override
			public void run() {
				System.out.println(getName() +"실행");
			}
		};
		
		charThread.setName("char-thread");
		charThread.start();
	}

}
