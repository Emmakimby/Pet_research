package pet_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDao {
	private JdbcTemplate JdbcTemplate;
	
	public ResultDao() {
		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
	}

	public int selsctmAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\"";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctmYAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where pet_yn='Y'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctmNAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where pet_yn='N'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctAll1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where PET_HOUSE =1 and pet_yn='Y'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctAll2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where PET_HOUSE =2 and pet_yn='Y'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctAll3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where PET_HOUSE =3 and pet_yn='Y'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctAll4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where PET_HOUSE =4 and pet_yn='Y'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public int selsctAll5() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -9999;
		String sql = "select count(*) from \"MAN_INFO\" where PET_HOUSE =5 and pet_yn='Y'";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
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
		return result;

	}

	public List<ResultVo> TypeAll() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ResultVo> ls = new ArrayList<>();

		String sql = "select * \n" + 
				"from (\n" + 
				"select distinct a.type_no\n" + 
				", a.pet_type\n" + 
				", count(*) over(PARTITION BY b.pet_type_pet_no) as Total\n" + 
				"from pet_info b\n" + 
				"join pet_type a\n" + 
				"on a.type_no = b.pet_type_pet_no\n" + 
				")\n" + 
				"order by type_no";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				ResultVo tmp = new ResultVo();
				tmp.setTypeNo(rs.getLong("TYPE_NO"));
				tmp.setType(rs.getString("PET_TYPE"));
				tmp.setTatal(rs.getLong("TOTAL"));
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
	
	public List<ResultavgVo> Typeavg() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ResultavgVo> ls = new ArrayList<>();

		String sql = "select * \n" + 
				"from (\n" + 
				"select distinct a.type_no\n" + 
				", a.pet_type\n" + 
				", avg(b.pet_age) as Total\n" + 
				"from pet_info b\n" + 
				"join pet_type a\n" + 
				"on a.type_no = b.pet_type_pet_no group by a.type_no, a.pet_type\n" + 
				")\n" + 
				"order by type_no";
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				ResultavgVo tmp = new ResultavgVo();
				tmp.setTypeNo(rs.getLong("TYPE_NO"));
				tmp.setType(rs.getString("PET_TYPE"));
				tmp.setTatal(rs.getLong("TOTAL"));
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
