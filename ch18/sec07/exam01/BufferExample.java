package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {

	public static void main(String[] args) {
		try {
			//버퍼가 없는 스트림 생성
		String originalFilePath1 = BufferExample.class.getResource("originalFile1.jpg").getPath(); //절대경로에대한 문자열.
		String  targetFilePath1 ="C:/Temp/targetFile1.jpg";
		
		
			
		FileInputStream fis1 = new FileInputStream(originalFilePath1);
		FileOutputStream fos1 = new FileOutputStream(targetFilePath1);
		
		
		//버퍼가 있는 스트림 생성	String originalFilePath1 = BufferExample.class.getResource("originalFile1.jpg").getPath(); //절대경로에대한 문자열.
		String originalFilePath2 = BufferExample.class.getResource("originalFile2.jpg").getPath();
		String  targetFilePath2 ="C:/Temp/targetFile2.jpg";
		
		
			
		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		//복사시간 측정
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼 미사용: \t"+ nonBufferTime +"ns");
		
		long bufferTime = copy(bis, bos);
		System.out.println("버퍼 사용: \t"+ bufferTime +"ns");
		
		fis1.close();
		fos1.close();
		bis.close();
		bos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static long copy(InputStream is, OutputStream os ) throws Exception{
		long start = System.nanoTime();
		
		//copy=한쪽에서 읽고 씀
		while(true) {
			int data= is.read(); //한번에 한바이트씩. 왜? 배열 안주어져서!
			if(data==-1) break;
			os.write(data); // 느리게 복사하기위해 쫌쫌따리 저장.
		}
		
		os.flush(); //데이터가 문열고 나감
		
		long end= System.nanoTime();
		
		return (end-start);
	}
}
