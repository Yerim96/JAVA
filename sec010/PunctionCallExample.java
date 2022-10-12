package ch20.oracle.sec010;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class PunctionCallExample {

	public static void main(String[] args) {
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.Oracl"
					+ "eDriver"); //Driver 클래스를 메모리로 로딩해 등록하는 작업.
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","java" ,"oracle"); //getConnerct 연결문자열안에는 ip,portnumber,dbname이 있다. db마다 연결 문자열은 다르다.)
			System.out.println("연결성공");
			
			String sql = "{? = call user_login(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, "winter");
			cstmt.setString(3, "123456");
			
			cstmt.execute();
			int result = cstmt.getInt(1);
			
			cstmt.close();
			
			String message = switch(result) {
			case 0 ->"로그인 성공";
			case 1 ->"비밀번호 틀림";
			default ->"아이디가 존재하지 않음";
			};
			System.out.println(message);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					
				}
				System.out.println("연결끊김");
			}
		}

	}

}
