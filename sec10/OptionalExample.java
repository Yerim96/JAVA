package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		/*double avg = list.stream()
				.mapToInt(Integer ::intValue)
				.average()
				.getAsDouble();*/
				
				
		//방법1
		OptionalDouble optinal = list.stream()
		.mapToInt(Integer ::intValue)
		.average();
		if(optinal.isPresent()) {
			System.out.println("방법1 평균" + optinal.getAsDouble());
		}else {
			System.out.println("방법 1 평균 : 0.0");
		}

		
		//방법2
		
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		System.out.println("방법 2 평균"+ avg);
		
		//방법3
		
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(a-> System.out.println("방법3 평균" + a));
	}

}
