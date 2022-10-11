package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.BLOB;

public class BoardSelectExample {

	public static void main(String[] args) {
		Connection conn =null; 
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverMannager에 등록
			Class.forName("oracle.jdbc.Oracl"
					+ "eDriver"); //Driver 클래스를 메모리로 로딩해 등록하는 작업.
			
			//DB와 연결
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","java" ,"oracle"); //getConnerct 연결문자열안에는 ip,portnumber,dbname이 있다. db마다 연결 문자열은 다르다.)
			System.out.println("연결성공");
				
			//DB작업
			String sql ="select bno, btitle, bcontent, bwriter,bdate, bfilename, bfiledata from boards where bwriter=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql); //가져오고싶은 컬럼의 이름을 배열로 가져옴. 실행하고 나서 가져올 수 있다. 
			
			//DB지정
			//실제 db컬럼의 데이터타입을 봐야함. 인서트 네임만 보고 추측하지 말기!
			pstmt.setString(1,"winter"); //userid에 같은 값 넣지 말기. 중복발생하면 예외 발생.
			
			List<Board> boards = new ArrayList<>();
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(); 
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfileName(rs.getString("bfilename"));
				board.setBfileData(rs.getBlob("bfiledata"));
				//boards.add(board); //3개의 보드 객체 저장함.
				
				Blob blob = board.getBfileData();
				if(blob!=null) {
				InputStream is = blob.getBinaryStream();
				OutputStream os = new FileOutputStream("C:/Temp/"+board.getBfileName());
				is.transferTo(os);
				os.flush();
				is.close();
				os.close();
				}
				
				boards.add(board);
			
			}
			rs.close();
			
			printBoards(boards); //보드 객체를 한꺼번에 3개를 넘겨줌.
		
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
	public static void printBoards(List<Board> boards) { //리스트컬렉션으로 바뀜
		/*for(Board board: boards) {
			System.out.println(board);
		}*/
		
		boards.stream().forEach(b-> System.out.println(b));
	}
	

}
