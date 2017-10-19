package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfficeDAO {
	private int count;

	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "system";
	private String password = "123";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Office> select_office() {
		ArrayList<Office> list = new ArrayList<Office>();
		
		try {
			getConnection();
			String sql = "select office_id, office_pass, office_num from office";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				int num = rs.getInt(3);
				list.add(new Office(num, id, pw));
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
	public void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
	}

	public int office_update(String change_pass, String ID , int num) {
		try {
			getConnection();

			String sql = "update office set office_pass = ? where office_ID = ? and office_num = ?";
			psmt = con.prepareStatement(sql);

			psmt.setString(1, change_pass);
			psmt.setString(2, ID);
			psmt.setInt(3, num);

			count = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}

