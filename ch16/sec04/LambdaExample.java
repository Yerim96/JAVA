package ch16.sec04;

public class LambdaExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		person.action((x,y)->{ //10과 4가 들어옴
			//리턴타입이 있어서 반드시 리턴문이 작성되어야함.
			double result = x+y;
			return result;
		});
		
		person.action((x,y)-> x+y);
		
		person.action((x,y)->{ return sum(x,y);});
		//10과 4가 들어옴
			//리턴타입이 있어서 반드시 리턴문이 작성되어야함.
		person.action((x,y)-> sum(x,y));
		
		
	}
	public static double sum(double x, double y) {
		return(x+y);
	}

}
