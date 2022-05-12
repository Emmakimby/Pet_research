package pet_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Man_InfoDao {
	private JdbcTemplate JdbcTemplate;
	Scanner in = new Scanner(System.in);

	public Man_InfoDao() {
		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
	}

	public boolean insertMan_Info(Man_InfoVo Mvo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"MAN_INFO\" values (\"PET_INFONO\".nextval, ?, ?, ?)";
		try {
			conn = JdbcTemplate.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Mvo.getAge());
			pstmt.setLong(2, Mvo.getHouse());
			pstmt.setString(3, Mvo.getPet());

			int result = pstmt.executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public long searchNumber(Man_InfoVo Mvo) {
		long number = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"NUMBER\"\n" + 
				"from \"MAN_INFO\"\n" + 
				"where \"AGE\" = ? and \"PET_HOUSE\" = ? and \"PET_YN\" = ?";
		try {
			conn = JdbcTemplate.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Mvo.getAge());
			pstmt.setLong(2, Mvo.getHouse());
			pstmt.setString(3, Mvo.getPet());
			
			rs = pstmt.executeQuery();

			while (rs.next())
				number= rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return number;
	}

	public List<Man_InfoVo> selsctAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Man_InfoVo> ls = new ArrayList<>();

		String sql = "select \"NUMBER\", \"AGE\", \"PET_HOUSE\", \"PET_YN\" from MAN_INFO";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Man_InfoVo tmp = new Man_InfoVo();
				tmp.setAge(rs.getInt("AGE"));
				tmp.setNumber(rs.getInt("NUMBER"));
				tmp.setHouse(rs.getInt("PET_HOUSE"));
				tmp.setPet(rs.getString("PET_YN"));

				ls.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;

	}

}
