package ch12.sec06;
import java.util.Arrays;
import java.util.Random;
public class RandomExample {

	public static void main(String[] args) {
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.println("선택번호: ");
		for(int i=0; i<6; i++) {
			selectNumber[i]=random.nextInt(45)+1;
			System.out.print(selectNumber[i]+" ");	
		}
		System.out.println();
		
		int[] winningNumber= new int[6];
		random= new Random(5);
		System.out.println("당첨번호: ");
		for(int i=0; i<6; i++) {
			selectNumber[i]=random.nextInt(45)+1;
			System.out.print(selectNumber[i]+" ");	
		}
		System.out.println();
		
		
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result= Arrays.equals(selectNumber,winningNumber);
		System.out.print("당첨여부");
		if(result) {
			System.out.print("1등에 당첨되셨습니다.");
		}else {
			System.out.print("당첨되지 않았습니다.");
		}
		

	}

}
