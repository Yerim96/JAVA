package ch16.sec05.exam03;

public class Member {
	private String id; //Member 필드
	private String name;
	
	public Member(String id) {//Member 생성자
		this.id=id;
		System.out.println("Member(String id)");
	}
	
	//오버라이드
	
	public Member(String id, String name) { //Member 생성자 2
		this.id=id;
		this.name=name;
		System.out.println("Member(String id, String name)");
	}
	
	@Override
	public String toString() {
		String info ="{id: " +id+", name: "+ name +"}";
		return info;
	}
}
