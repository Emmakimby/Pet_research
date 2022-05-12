package pet_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pet_TypeDao {
	private JdbcTemplate JdbcTemplate;
	Scanner in = new Scanner(System.in);

	public Pet_TypeDao() {
		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
	}

	public boolean insertPet_Type(Pet_TypeVo Tvo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PET_TYPE\" values (\"SEQ_PTYPE\".nextval, ?)";
		try {
			conn = JdbcTemplate.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Tvo.getType());

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
	public int searchNumber(Pet_TypeVo Tvo) {
		int number = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"TYPE_NO\"\n" + "from \"PET_TYPE\"\n"
				+ "where \"PET_TYPE\" = ?";
		try {
			conn = JdbcTemplate.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Tvo.getType());

			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1);
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
	public List<Pet_TypeVo> selsctAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Pet_TypeVo> ls = new ArrayList<>();

		String sql = "select \"TYPE_NO\", \"PET_TYPE\" from PET_TYPE";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				Pet_TypeVo tmp = new Pet_TypeVo();
				tmp.setTypeNo(rs.getLong("TYPE_NO"));
				tmp.setType(rs.getString("PET_TYPE"));
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
