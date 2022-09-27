package ch16.sec03;

public class LambdaExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		//person이 가지고 있는 메소드 가져오기
		
		person.action1((name,job)->{ //데이터 처리 내용.
			System.out.print(name+ "이 ");
			System.out.println(job+ "을 합니다. ");
			
		});
		
		person.action1((name,job)-> //데이터의 처리내용에 따라 결과가 달라진다.
			System.out.println(name+ "이 "+job+ "을 안합니다. ")
			
		);
		
		person.action2(word->
			System.out.println("\""+ word+"\n"+"라고 말합니다.")
			
		);
	}

}
