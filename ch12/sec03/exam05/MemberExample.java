package ch12.sec03.exam05;
//롬복 사용하기 
//롬복은 jDK에 포함된 표준 라이브러리는 아니지만 개발자들이 즐겨쓰는 코드 생성라이브러리다.
//DTO 클래스와 동일한점은 Getter() Setter() hasCode(), equals(), toString() 메소드를 자동 생성하기 떄문에 코드양 줄여줌
//DTO= 레코드 와의 차이는 필드가 final이아니며 값을 읽는 getter는 getxxx,isxxx, Setter는 setxxx 로 생성 
import java.util.HashSet;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 =new Member("fall","단풍이"); //어노테이션 안에 기본생성자가 없기에  값을 넣어줘야함.
		Member m2 =new Member("fall","단풍이");
	
		System.out.println(m1);
		System.out.println(m2);
		
		System.out.println(m1.hashCode()); // 객체의 생성번지로 해시코드 만듦. 이것을 같도록 재정의함.
		System.out.println(m2.hashCode());
		
		System.out.println(m1.equals(m2)); //데이터가 똑같기 떄문에.
		
		HashSet hashSet= new HashSet(); //아이디 같고 이름같으니 동등객체로 판단.
		hashSet.add(m1);
		hashSet.add(m2);
		System.out.println(hashSet.size());
	}

}
