package pet_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pet_InfoDao {

	private JdbcTemplate JdbcTemplate;
	Scanner in = new Scanner(System.in);

	public Pet_InfoDao() {
		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
	}

	public boolean insertPet_Info(long manNum, Pet_InfoVo Pvo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PET_INFO\" values (?, ?, ?, ?)";
		try {
			conn = JdbcTemplate.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, manNum);
			pstmt.setLong(2, Pvo.getTypeNo());
			pstmt.setObject(3, Pvo.getName());
			pstmt.setLong(4, Pvo.getPetAge());

			//System.out.println(sql);
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

	public List<Pet_InfoVo> selsctAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Pet_InfoVo> ls = new ArrayList<>();

		String sql = "select \"MAN_INFO_PET_NO\", \"PET_TYPE_PET_NO\", \"PET_NAME\", \"PET_AGE\" from PET_INFO";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Pet_InfoVo tmp = new Pet_InfoVo();
				tmp.setNumber(rs.getLong("MAN_INFO_PET_NO"));;
				tmp.setTypeNo(rs.getLong("PET_TYPE_PET_NO"));
				tmp.setName(rs.getString("PET_NAME"));
				tmp.setPetAge(rs.getLong("PET_AGE"));
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
