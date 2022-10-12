package ch20.oracle.sec011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExampl {

	public static void main(String[] args) {
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn= DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl",
					"java",
					"oracle"
					);
			
			//트랜잭션 시작
			//자동커밋 기능 끄기
			
			conn.setAutoCommit(false);
			
			//출금작업
			String sql1 ="UPDATE accounts SET balance=balance-? WHERE ano=?";
			PreparedStatement pstmt1= conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int row1 = pstmt1.executeUpdate();
			if(row1==0) throw new Exception("출금되지 않았음");
			pstmt1.close();
			
			
			//입금작업
			
			String sql2 ="UPDATE accounts SET balance=balance+? WHERE ano=?";
			PreparedStatement pstmt2= conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int row2 = pstmt2.executeUpdate();
			if(row2==0) throw new Exception("입금되지 않았음");
			pstmt2.close();
			
			conn.commit();
			System.out.println("계좌이체 성공");
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {}
			System.out.println("계좌이체 실패");
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.setAutoCommit(true);
					//연결끊기
					conn.close();
				}catch(SQLException e) {}
			}
		}

	}

}
