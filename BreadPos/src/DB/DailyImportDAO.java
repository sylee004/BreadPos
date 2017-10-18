package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DailyImportDAO {
	private int count;

	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "system";
	private String password = "123";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public int daily_insert(Daily daily) {

		try {
			getConnection();

			String sql = "insert into daily_import(daily_day, daily_money, daily_officeNum values(?, ?, ?)";
			psmt = con.prepareStatement(sql);

			psmt.setInt(1, daily.getDay());
			psmt.setInt(2, daily.getMoney());
			psmt.setInt(3, daily.getOfficeNum());

			count = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
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

	public int daily_update(int money, int officeNum) {
		try {
			getConnection();

			String sql = "update daily_import set daily_money = ? where daily_officeNum = ?";
			psmt = con.prepareStatement(sql);

			psmt.setInt(1, money);
			psmt.setInt(2, officeNum);

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

	public ArrayList<Daily> selectAll() {
		ArrayList<Daily> list = new ArrayList<Daily>();

		try {
			getConnection();

			String sql = "select * from daily_import";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int day = rs.getInt(1);
				int money = rs.getInt(2);
				int officeNum = rs.getInt(3);
				list.add(new Daily(day, money, officeNum));
			}

			psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
}
