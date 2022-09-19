package ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ByteToStringExample {
//String class 디코딩과 인코딩 
	public static void main(String[] args) {
		String data ="a자바"; 
		
		try {
			//인코딩(decoding): String-> byte[]
			byte[] arr1 = data.getBytes("EUC-KR"); //인코딩
			
			System.out.println(arr1.length); //문자셋의 번호로 바이트
			System.out.println(Arrays.toString(arr1));
			
			//디코딩(decoding): byte[]-> String
			
			String data2= new String(arr1,"EUC-KR");
			System.out.println(data2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //디코딩
		
		
		//System.out.println(arr1.length);//배열의 속성은 length로읽을수있다.
		//byte[] arr1 =data.getBytes();
		
		//System.out.println(arr1.length); //문자셋의 번호로 바이트
		//System.out.println(Arrays.toString(arr1));
		
	}

}
