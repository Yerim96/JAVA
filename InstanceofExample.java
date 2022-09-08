package ch07.sec09;

public class InstanceofExample {
	public static void personInfo(Person person) {
		System.out.println("name :"+person.name);
		person.walk();
	}
	
	public static void main(String[] args) {
		Person p1= new Person("홍길동"); //Person타입의 p1 객체 생성
		personInfo(p1);
		
		System.out.println();
		
		Person p2 = new Student("김길동",10);
		personInfo(p2);
	}
}
