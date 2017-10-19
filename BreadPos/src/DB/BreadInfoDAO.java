package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BreadInfoDAO {
	private int count;
	
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "system";
	private String password = "123";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public int bread_insert(Bread bread) {
		
		try {
			getConnection();
			
			String sql = "insert into bread_info(bread_name, bread_price, bread_kind values(?, ?, ?)";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, bread.getName());
			psmt.setInt(2, bread.getPrice());
			psmt.setString(3, bread.getKind());
			
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

	public int bread_update(Bread bread) {
		try {
			getConnection();
			
			String sql = "update bread_info set bread_kind = ?, bread_price= ? where bread_name = ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, bread.getKind());
			psmt.setInt(2, bread.getPrice());
			psmt.setString(3, bread.getName());
			
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

	public int delete(String name) {

		try {
			getConnection();
			
			String sql = "delete bread_info where bread_name = ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, name);
			
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

	public ArrayList<Bread> selectKind(String bread_kind) {
		ArrayList<Bread> list = new ArrayList<Bread>();
		
		try {
			getConnection();
			
			String sql = "select * from bread_info where bread_kind = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, bread_kind);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				String kind = rs.getString(3);
				list.add(new Bread(name, price, kind));
			}
			
			//psmt.executeUpdate();
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
	
	public ArrayList<Bread> select_bread() {
		ArrayList<Bread> list = new ArrayList<Bread>();
		
		try {
			getConnection();
			String sql = "select bread_name, bread_price from bread_info where =?";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String breadName = rs.getString(1);
				int breadPrice = rs.getInt(2);
				
				list.add(new Bread(breadName, breadPrice));
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

}
