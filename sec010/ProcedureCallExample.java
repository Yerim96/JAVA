package ch20.oracle.sec010;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import ch20.oracle.sec09.exam02.Board;

public class ProcedureCallExample {

	public static void main(String[] args) {
		Connection conn =null; 
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverMannager에 등록
			Class.forName("oracle.jdbc.Oracl"
					+ "eDriver"); //Driver 클래스를 메모리로 로딩해 등록하는 작업.
			
			//DB와 연결
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","java" ,"oracle"); //getConnerct 연결문자열안에는 ip,portnumber,dbname이 있다. db마다 연결 문자열은 다르다.)
			System.out.println("연결성공");
				
			
		
			String sql = "{call user_create(?,?,?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "summer");
			cstmt.setString(2, "한여름");
			cstmt.setString(3, "12345");
			cstmt.setInt(4, 26);
			cstmt.setString(5, "summer@mycompany.com");
			cstmt.registerOutParameter(6, Types.INTEGER);
			
			cstmt.execute();
			int rows = cstmt.getInt(6);
			System.out.println("저장된 행 수 " +rows);
			
			cstmt.close();
			
			
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 
		}finally {
			if(conn!=null) { //null이면 close 필요 없으나 null이면 close
			try {
				conn.close();
			} catch (Exception e) {

			} 
			System.out.println("연결해제");
		}
		
		

		}
	}

}
