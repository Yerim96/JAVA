package ch16.sec02.exam01;

@FunctionalInterface
public interface Workable {
	 public void work();//Workable 인터페이스 추상메소드 work. 어노테이션 FunctionalInterface는 추상 메소드가 하나인지 확인해준다.
	//익명구현객체 대신으로 람다식, 함수형 프로그래밍을 하려면 인터페이스에 추상메소드가 하나여야하는건 맞지만, 다른 인터페이스 멤버는 수가 몇개든 상관 없다.
}
