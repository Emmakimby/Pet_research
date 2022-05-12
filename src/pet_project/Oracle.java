package pet_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle {
	public static void main(String[] aegs) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@oracl_high?TNS_ADMIN=/Users/kimbuyeon/Wallet_oracl","ADMIN","Dusghk9321!!");
				System.out.println("데이터베이스 접속 성공!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
