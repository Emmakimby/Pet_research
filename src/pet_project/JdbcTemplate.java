package pet_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	
	private static JdbcTemplate instance;
	private String ur1 = "jdbc:oracle:thin:@oracl_high?TNS_ADMIN=/Users/kimbuyeon/Wallet_oracl";
	private String id = "ADMIN";
	private String pw = "Dusghk9321!!";

	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static JdbcTemplate getInstance() {
		synchronized (JdbcTemplate.class) {
			if (instance == null) {
				instance = new JdbcTemplate();
			}
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ur1, id, pw);

	}

}
