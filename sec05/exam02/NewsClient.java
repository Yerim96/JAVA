package ch19.sec05.exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class NewsClient {

	public static void main(String[] args) {
		try {
			//DatagramSocket 생성
			DatagramSocket datagramSocket = new DatagramSocket();
			//구독하고 싶은 뉴스 주제 보내기 
			String data="정치";
			byte[] bytes =data.getBytes("UTF-8"); //인코딩된정보들어가있음.
			DatagramPacket sendpacket = new DatagramPacket(bytes,0, bytes.length, new InetSocketAddress("localhost",50001));
			datagramSocket.send(sendpacket);
			
			while(true) {
				//뉴스 받기 (10개)
				//비어있는 데이터그램패킷만들고 receive로 만든다.
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);
				
				//문자열로 변환
				String news = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
				System.out.println(news);
				
				//10번쨰 뉴스를 받으면 while문을 종료시키자.
				if(news.contains("100")) {
					break;
				}
			
			}
			//DatagramSoket 닫기
			datagramSocket.close();
		} catch (Exception e) {
			System.out.println("[클라이언트]" +e.getMessage());
			e.printStackTrace();
		} //고정된 포트x 자동적 포트 ㅐ
		

	}

}
