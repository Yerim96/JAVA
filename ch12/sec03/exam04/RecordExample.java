package ch12.sec03.exam04;
//레코드 선언 - DTO (데이터를 기록한 객체 넘기기 
//자동적으로 값을 얻어내고 자동적으로 비교할 수 있는 코드를 생성해준다.
public class RecordExample {

	public static void main(String[] args) {
		Member m= new Member("winter","눈송이",25); {
			System.out.println(m.id());
			System.out.println(m.name());
			System.out.println(m.age());
			System.out.println(m.toString());
			System.out.println();
		
		
			Member m1= new Member("winter","눈송이",25);
			Member m2= new Member("winter","눈송이",25);
			
			System.out.println("m1.hashcode():" +m1.hashCode());
			System.out.println("m2.hashcode():" +m1.hashCode());
			System.out.println("m1.hashcode():" +m1.equals(m2));
		}

	}

}
