package ch19.sec07;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	ChatServer chatServer;
	Socket socket;
	String clientIp;
	String chatName;
	DataInputStream dis;
	DataOutputStream dos;
	
	public SocketClient(ChatServer chatServer, Socket soket) {
		try {
			this.chatServer=chatServer;
			this.socket=soket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos =new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa =(InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp =isa.getHostName();
			receive();
		} catch (IOException e) {
		}
	}
	private void receive() {//클라이언트가 데이터를 받기 메소드
		//클라이언트가 언제 메시지를 보낼지는 모름. 받을준비하고있어야함.

		chatServer.threadPool.execute(()->{
			
				try {
					while(true) {
						//{"command":"incoming","data":"chatName"} 채팅방에들어오고싶으면 채팅할때의 채팅이름.
						//{"command":"message","data":"content"}	
					String receiveJson = dis.readUTF();
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command= jsonObject.getString("command");
					
					switch(command) {
					case "incoming": 
						this.chatName= jsonObject.getString("data");
						chatServer.sendToAll(this, "들어오셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this,message);
						break;
					}
				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
				
					}
			
		}); //작업큐에작업저장. runnable 객체 람다식으로 표현
			
	}
	public void send(String json) {//클라이언트가 데이터를 보내기위한 메소드
		try {
			dos.writeUTF(json);
			dos.flush(); //재사용해야해서 close안함.
		} catch (IOException e) {
			
		}
	}
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {

		}

	}
}
