package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoExample {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[클라이언트] 연결 성공");
			//----------------------------------------
			
			//데이터보내기
			String sendMessage = "나는 자바가 좋아";
			//OutputStream os = socket.getOutputStream();
			//byte[] bytes= sendMessage.getBytes("UTF-8");
				//os.write(bytes);
			//os.flush();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄" + sendMessage);
			
			//데이터받기
			//InputStream is = socket.getInputStream();
			//bytes = new byte[1024];
			//int readByteCount = is.read(bytes);
			//String receiveMessage = new String(bytes,0,readByteCount, "UTF-8");
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터받음"+receiveMessage);
			//------------------------------------------
			
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
