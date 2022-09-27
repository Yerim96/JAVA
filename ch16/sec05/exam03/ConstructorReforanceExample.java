package ch16.sec05.exam03;

public class ConstructorReforanceExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		Member m1 = person.getMember1(id->{ //생성자호출해서 객체만듦.
			Member  m = new Member(id);
			return m;  //람다식 제공
		}); //구현객체 , 즉 람다식이 들어올 수 있다.
		System.out.println(m1);
		
		m1 = person.getMember1((id)-> new Member(id));
		m1 = person.getMember1(Member::new);
		
		//-----------------------------------------------
		//getMember2
		Member m2 =person.getMember2((id,name)-> {
			Member m = new Member(id, name);
			return m;
		});
		
		 m2 =person.getMember2((id,name)-> {
			return new Member(id, name);
		});
		 m2 =person.getMember2((id,name)-> new Member(id, name));
		 m2 =person.getMember2(Member:: new);

	}

}
