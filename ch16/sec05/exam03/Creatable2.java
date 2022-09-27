package ch16.sec05.exam03;

@FunctionalInterface
public interface Creatable2 {
	public Member create(String id, String name); //id와 name을 가지고 있는 Member객체가 나온다.
}
