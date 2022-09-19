package ch12.sec05;

public class BoxingUnBoxingExample {
//박스와 언박싱
	public static void main(String[] args) {
		//Boxing
		Integer obj = 100;
		System.out.println("value"+obj.intValue());
		
		//unboxing 
		int value = obj;
		System.out.println("value"+ value);
		
		int result = obj+100;
		System.out.println("result"+ result);

	}

}
