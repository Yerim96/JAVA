package ch16.sec05.exam02;

public class MethodReferanceExample {

	public static void main(String[] args) {
		Person person = new Person(); //ordering이 인스턴스라 객체먼저만드렁줌.
		person.ordering((a,b)-> {
			return a.compareToIgnoreCase(b); //a가 스트링타입. 즉 스트링이가지고있는 메소드.
		}); 
		
		person.ordering((a,b)-> a.compareToIgnoreCase(b));
		person.ordering(String :: compareToIgnoreCase);
		//a가가지고있는 인스턴스메소드를가지고 b랑 비교함. 음수가 나오면 a가 더 작다는것(앞에온다는것)
		


	}

}
