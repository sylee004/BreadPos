package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	private int count;
	
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "system";
	private String password = "123";
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public int product_insert(Product product) {
		
		try {
			getConnection();
			
			String sql = "insert into product_list(pname, amount, price) values(?, ?, ?)";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, product.getPname());
			psmt.setInt(2, product.getAmount());
			psmt.setInt(3, product.getPrice());
			
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

	public int product_update(Product product) {
		try {
			getConnection();
			
			String sql = "update product_list set amount = ?, price= ? where pname = ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, product.getAmount());
			psmt.setInt(2, product.getPrice());
			psmt.setString(3, product.getPname());
			
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

	public int product_delete() {

		try {
			getConnection();
			
			String sql = "delete product_list";
			psmt = con.prepareStatement(sql);
			
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

//	public Product product_select_pname(String pname) {
//		Product list = null;
//		
//		try {
//			getConnection();
//			
//			String sql = "select * from product_list where Pname = ?";
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, pname);
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				String name = rs.getString(1);
//				int amount = rs.getInt(2);
//				int price = rs.getInt(3);
//				list = new Product(name, amount, price);
//			}
//			
//			//psmt.executeUpdate();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (psmt != null) psmt.close();
//				if (con != null) con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		return list;
//	}
	
	public ArrayList<Product> product_select() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			getConnection();
			String sql = "select pname, amount, price from product_list";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String Name = rs.getString(1);
				int amount = rs.getInt(2);
				int price = rs.getInt(3);
				list.add(new Product(Name, amount, price));
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
