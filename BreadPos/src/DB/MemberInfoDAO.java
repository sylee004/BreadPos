package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberInfoDAO {
private int count;
	int total_money=0;
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "system";
	private String password = "skylha10";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public int member_insert(Member member) {
		
		try {
			getConnection();
			
			String sql = "insert into member_info(member_phone, member_name) values(?, ?)";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, member.getMember_phone());
			psmt.setString(2, member.getMember_name());
			
			count = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	public void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
	}
	
	
	public int member_update(String change_phone, String change_name, String phone, String name) {
		try {
			getConnection();
			
			String sql = "update member_info set member_phone = ?, member_name = ? where member_phone = ? and member_name = ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, change_phone);
			psmt.setString(2, change_name);
			psmt.setString(3, phone);
			psmt.setString(4, name);
		
			
			count = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int delete(String name, String phone) {

		try {
			getConnection();
			
			String sql = "delete member_info where member_name = ? and member_phone = ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, name);
			psmt.setString(2, phone);
			
			count = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	public ArrayList<Member> selectPhone(String member_name) {
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			getConnection();
			
			String sql = "select * from member_info where member_name = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member_name);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String member_phone = rs.getString(1);
				String name = rs.getString(2);
				int member_Money = rs.getInt(3);
				list.add(new Member(member_phone, name, member_Money));
			}
			
			psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<Member> selectName(String member_phone) {
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			getConnection();
			
			String sql = "select * from member_info where member_name = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member_phone);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String phone = rs.getString(1);
				String name = rs.getString(2);
				int member_Money = rs.getInt(3);
				list.add(new Member(phone, name, member_Money));
			}
			
			psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int member_updateMoney(String phone, String name, int money) {
		try {
			getConnection();
			
			String sql = "update member_info set member_money = ? where member_phone = ? and member_name = ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, money);
			psmt.setString(2, phone);
			psmt.setString(3, name);
		
			count = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int selectMoney(String member_name, String member_phone) {
		int member_Money = 0;
		try {
			getConnection();
			
			String sql = "select member_money from member_info where member_name = ? and member_phone = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member_name);
			psmt.setString(2, member_phone);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				member_Money = rs.getInt(1);
			}
			
			psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member_Money;
	}

}
