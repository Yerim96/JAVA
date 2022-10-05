package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[클라이언트] 연결 성공");
			
			socket.close();
			System.out.println("[클라이언트] 연결 성공");
		} catch (UnknownHostException e) {
			//ip또는 도메인 표기 방법이 잘못되었을경우
			System.out.println("UnknownHostException"+e.toString());

			
		} catch (IOException e) {
			//ip또는 Port 번호 존재하지 않을 경우
			System.out.println("IOException"+e.toString());
			
		}
		
	}

}
