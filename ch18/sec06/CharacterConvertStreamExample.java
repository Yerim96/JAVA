package ch18.sec06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {

	public static void main(String[] args) {
		
//파일에 문자를 저장하고 싶다. 문자를 저장하니 filewrite를 쓰면 되는데 fileoutput을 쓰게 되었다.
		try {
			//OutputStream os = new FileOutputStream("C:/Temp/test.txt");
			//Writer writer = new OutputStreamWriter(os,"UTF-8");
			//갖고있는 문자 저장
			//String str="문자 변환 스트링을 사용합니다."; 
			//byte[] data= str.getBytes("UTF-8"); //인코딩 3바이트
			//문자열 바로 입력하고 싶음 중간 바이트로 안만들고... str을 바로 출력하고싶음. 
		   // writer.write(str);
		   // writer.flush();
			//writer.close();
	
			write("문자 변환 스트림을 사용합니다.");
			String str = read();
			System.out.println(str);
			
			
			
			
//파일 출력하고 싶음
			//InputStream is =new FileInputStream("C:/Temp/test.txt");
			//간편하게 바꾸기위해 reader 사용
			//Reader reader = new InputStreamReader(is , "UTF-8");
			//char[] data = new char[20];
			//int num = reader.read(data);
			//String str2 = new String(data, 0, num);
			//System.out.println(str2);
			
			//byte[] data = new byte[100]; //문자열 한번에 읽을수있도록함.
			//int num = is.read(data);
			//String str2 = new String(data,"UTF-8"); //
			//System.out.println(str2);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static void write(String str) throws IOException {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		
		Writer writer = new OutputStreamWriter(os,"UTF-8");
	    writer.write(str);
	    writer.flush();
		writer.close();
	}
	public static String read() throws IOException {
		/*InputStream is =new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is , "UTF-8");
		char[] data = new char[20];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0, num);
		return str;*/
		
		InputStream is =new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is , "UTF-8");
		//inputstreamreader에 이은 보조스트림
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		return str;
	}
}
