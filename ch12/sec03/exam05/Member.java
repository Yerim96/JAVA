package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Data
public class Member {
	

	private final String id; //final이라 기본생성자가 있으면 안됨.
	@NonNull private String name; //멤버라는 이름이 없을수가 없다! 무조건 값있어야함. 생성자를 통해
	private int age;
}
