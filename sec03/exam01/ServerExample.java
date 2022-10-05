package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSoket;

	public static void main(String[] args) {
		System.out.println("---------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 enter키를 입력하세요");
		System.out.println("-----------------------------------------------");
		
		//tcp 서버 시작
		
		startServer();
		
		//z키보드입력
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		//tcp 서버 종료 
		stopServer();
	}
	
	public static void startServer() {//서버시작메소드
	//작업 스레드 정의
		Thread thread = new Thread() {; //스레드의 자식객체를 만들어 생성
		@Override
		public void run() {
			
			try {
				//serversocket 생성 및 port 바인딩
				serverSoket = new ServerSocket(50001);
				System.out.println("[서버] 시작됨");
				
				while(true) {
					System.out.println("\n[서버] 연결 요청을 기다림\n");
					//연결 수락 
					Socket socket = serverSoket.accept(); //연결요청이 들어오면 블락플림
					// 연결된 클라이언트의 ip 주소, 포트번호를 알 수있다.
					InetSocketAddress isa= (InetSocketAddress) socket.getRemoteSocketAddress(); //받을때는 
					String clientIP = isa.getHostString();
					System.out.println("[서버]"+ clientIP +"와 연결 요청을 수락함");
					//연결 끊는 방법 소켓을 닫음으로 
					socket.close();
					System.out.println("[서버]"+ clientIP +"와 연결을 끊음");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("[서버]"+ e.toString());
				e.printStackTrace();
			}
		}
		};
		thread.start();
	}

	public static void stopServer() {
		//ServerSoket을 닫고 Port 언바인딩
		try {
			serverSoket.close();
		} catch (IOException e) {

		}
	}
}
