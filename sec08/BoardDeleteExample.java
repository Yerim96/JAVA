package ch20.oracle.sec08;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDeleteExample {

	public static void main(String[] args) {
		Connection conn =null; //Connerction은 인터페이스
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverMannager에 등록
			Class.forName("oracle.jdbc.Oracl"
					+ "eDriver"); //Driver 클래스를 메모리로 로딩해 등록하는 작업.
			
			//DB와 연결
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","java" ,"oracle"); //getConnerct 연결문자열안에는 ip,portnumber,dbname이 있다. db마다 연결 문자열은 다르다.)
			System.out.println("연결성공");
				
			//DB작업
			String sql ="delete from boards where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql); //가져오고싶은 컬럼의 이름을 배열로 가져옴. 실행하고 나서 가져올 수 있다. 
			
			//DB지정
			//실제 db컬럼의 데이터타입을 봐야함. 인서트 네임만 보고 추측하지 말기!
			pstmt.setString(1,"winter"); //userid에 같은 값 넣지 말기. 중복발생하면 예외 발생.
			int rows = pstmt.executeUpdate(); //저장된 행수 리턴
			System.out.println("삭제된 행수" +rows);
			
		
			pstmt.close();
	
			//DB연결 끊기
			//conn.close(); //예외발생되면 close안됨. 
			//System.out.println("연결해제");
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 
		}finally {
			if(conn!=null) { //null이면 close 필요 없으나 null이면 close
			try {
				conn.close();
			} catch (Exception e) {
;
			} 
			System.out.println("연결해제");
		}
		
		

	}


	}

}
