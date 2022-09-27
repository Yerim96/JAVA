package ch17.sec03;

import java.util.ArrayList;
import java.util.List;

public class StreamPipeLineExample {

	public static void main(String[] args) {
		List<Student> list = List.of(
			//List<Student> list = new ArrayList<>();
		   //list.add(new Student("홍길동", 10)); //가능
				new Student("홍길동", 10),
				new Student("김길동", 20),
				new Student("서길동", 30)
		);

		
		double avg = list.stream() //student가 흘러가는 stream처 리가 아닌 값을 변환하는 람다식.
				.mapToInt(student->student.getScore()) //중간처리.정수값으로 매핑
				.average() //최종처리
				.getAsDouble(); 
		System.out.println("평균점수" + avg);
		
		//학생이름만 뽑아낼떄
		list.stream() //stream얻어내기 
		.map(student -> student.getName()) //학생객체를 학생이름으로 매핑하겠다.
		.forEach(name -> System.out.println(name)); //하나씩받아서 출력.
	}

}
