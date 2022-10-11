package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSelectExample {

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
			String sql ="select userid, username, userpassword, userage, useremail from users where userid=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql); //가져오고싶은 컬럼의 이름을 배열로 가져옴. 실행하고 나서 가져올 수 있다. 
			
			//DB지정
			//실제 db컬럼의 데이터타입을 봐야함. 인서트 네임만 보고 추측하지 말기!
			pstmt.setString(1,"winter"); //userid에 같은 값 넣지 말기. 중복발생하면 예외 발생.
			ResultSet rs = pstmt.executeQuery(); //저장된 행수 리턴
			
			if(rs.next()) {
				/*String userId = rs.getString("userid");
				String userName = rs.getString("username");
				String userPassword = rs.getString("userpassword");
				int userAge=rs.getInt(4);
				String userEmail=rs.getString(5);
				printUser(userId, userName, userPassword, userAge, userEmail);*/
				
				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserAge(rs.getString("userAge"));
				user.setUserEmail(rs.getString("userEmail"));
				printUser(user);
			}else {
				System.out.println("사용자 아이디가 존재하지 않음");
				
			}
			
		
			rs.close();
	
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
	public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
		System.out.println("userId:"+ userId);
		System.out.println("userName:"+ userName);
		System.out.println("userPassword:"+ userPassword);
		System.out.println("userAge:"+ userAge);
		System.out.println("userEmail:"+ userEmail);
	}
	
	public static void printUser(User user) {
		System.out.println("userId:"+ user.getUserId());
		System.out.println("userName:"+ user.getUserName());
		System.out.println("userPassword:"+ user.getUserPassword());
		System.out.println("userAge:"+ user.getUserAge());
		System.out.println("userEmail:"+ user.getUserEmail());
	}

}
