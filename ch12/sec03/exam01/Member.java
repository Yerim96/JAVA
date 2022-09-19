package ch12.sec03.exam01;

public class Member extends Object {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {//어떤 자바객체든 대입 가능하다. 
		if(obj instanceof Member target) {//obj가 member로 만들어졌냐?
			if(id.equals(target.id)) { //동등비교 가능하도록 재정의
				return true;
			}
			
		}
		return false;
		
	}
}
