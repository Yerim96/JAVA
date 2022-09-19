package ch12.sec03.exam01;

public class MemberExample {
	public static void main(String[] arg) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		
		System.out.println(obj1 == obj2); //객체가 달라서 번지가 다르다.
		System.out.println(obj1.equals(obj2)); //오브젝의 이퀄스는 번지를 비교한다. 번지가 다르면 false
												//동등비교는 저절로 되지 않는다. 
		Member obj3 = new Member("red");
		
		System.out.println(obj1 == obj3);
		System.out.println(obj1.equals(obj3));
	}
}
