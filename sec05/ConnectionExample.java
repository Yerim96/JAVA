package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
		/*Connection conn =null;
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverMannager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB와 연결
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.15:1521/orcl","java" ,"oracle");
			System.out.println("연결성공");
				
			//DB작업
			
			//DB연결 끊기
			//conn.close(); //예외발생되면 close안됨. 
			//System.out.println("연결해제");
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
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
		}*/
		
		
		//자동리소스사용
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			try(Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.15:1521/orcl","java" ,"oracle");) {
				System.out.println("연결성공");
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			System.out.println("연결끊기");
			
		}catch(Exception e) {
			e.printStackTrace();
	}
	}

}
