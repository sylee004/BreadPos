package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class saleDAO {
   String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
   private String user = "system";
   private String password = "123";
   private Connection con = null;
   private PreparedStatement psmt = null;

   ResultSet rs = null;
   ArrayList<sale> list = null;
   
   
   public ArrayList<sale> selectAll() {

      // ResultSet �����͸� ���� �ִ� ����
      sale m = null;
      list = new ArrayList<>();
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         try {
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from member";

            psmt = con.prepareStatement(sql);

            rs = psmt.executeQuery();

            while (rs.next()) {

               String name = rs.getString(1);
               double sales = rs.getInt(2);
               int month = rs.getInt(3);

               m = new sale(name, sales, month);
               list.add(m);
            }
         } catch (SQLException e) {

            e.printStackTrace();
         }
      } catch (ClassNotFoundException e) {

         e.printStackTrace();
      } finally {
         // finally�� ���ܰ� �߻��ϴ� ���ϴ� ������ ����
         // �� ������ �ݴ��� �ݾƾߵȴ�.
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close(); // nullPointInception ����
            if (con != null)
               con.close();
         } catch (SQLException e) {
            // �ݴٰ� ������ �� ���� �־ Ʈ���� ĳġ
            e.printStackTrace();
         }

      }

      return list;
   }
   
   public ArrayList<sale> selectOneByName(String name) {
      // 1. �����ͺ��̽��� ����, ����̹�Ŭ������ �޸𸮿� �ε� Class.forName �ȿ� �ִ�.

      // ResultSet �����͸� ���� �ִ� ����
      ArrayList<sale> list2 = new ArrayList<>();
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // try/catch ����
         // �������ֵ��� �����ִ� Ŭ���� DriverManager url , user ,password �Է��ؾ� �Ѵ�.
         // ���Ŀ� �� try/catch ����
         try {
            con = DriverManager.getConnection(url, user, password);
            String sql = "select sales from monthlysale where name = ?";

            psmt = con.prepareStatement(sql);

            psmt.setString(1, name);

            rs = psmt.executeQuery();

            while (rs.next()) {
               // rs.nextĿ�� �����̴� ���

               double sale = rs.getDouble(1);
            
               // �ε����� Name PhoneNum Age ������ 1,2,3�� �ٴ´�.
               // ���⼭ ������ ���� ��� ���̺��� ������� ���̴�.
               // ��� ���̺��� �̸��� ���̸� �̴� ���̶�� �̸��� 1 ���̰� 2���� �ٴ´�.

               sale m = new sale(sale);
               list2.add(m);
            }
         } catch (SQLException e) {

            e.printStackTrace();
         }
      } catch (ClassNotFoundException e) {

         e.printStackTrace();
      } finally {
         // finally�� ���ܰ� �߻��ϴ� ���ϴ� ������ ����
         // �� ������ �ݴ��� �ݾƾߵȴ�.
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close(); // nullPointInception ����
            if (con != null)
               con.close();
         } catch (SQLException e) {
            // �ݴٰ� ������ �� ���� �־ Ʈ���� ĳġ
            e.printStackTrace();
         }

      }

      return list2;
   }
   
   public ArrayList<sale> selectByName(String name) {
      // 1. �����ͺ��̽��� ����, ����̹�Ŭ������ �޸𸮿� �ε� Class.forName �ȿ� �ִ�.

      // ResultSet �����͸� ���� �ִ� ����
      ArrayList<sale> list2 = new ArrayList<>();
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // try/catch ����
         // �������ֵ��� �����ִ� Ŭ���� DriverManager url , user ,password �Է��ؾ� �Ѵ�.
         // ���Ŀ� �� try/catch ����
         try {
            con = DriverManager.getConnection(url, user, password);
            String sql = "select month from monthlysale where name = ?";

            psmt = con.prepareStatement(sql);

            psmt.setString(1, name);

            rs = psmt.executeQuery();

            while (rs.next()) {
               // rs.nextĿ�� �����̴� ���

               double month = rs.getDouble(1);
            
               // �ε����� Name PhoneNum Age ������ 1,2,3�� �ٴ´�.
               // ���⼭ ������ ���� ��� ���̺��� ������� ���̴�.
               // ��� ���̺��� �̸��� ���̸� �̴� ���̶�� �̸��� 1 ���̰� 2���� �ٴ´�.

               sale m = new sale(month);
               list2.add(m);
            }
         } catch (SQLException e) {

            e.printStackTrace();
         }
      } catch (ClassNotFoundException e) {

         e.printStackTrace();
      } finally {
         // finally�� ���ܰ� �߻��ϴ� ���ϴ� ������ ����
         // �� ������ �ݴ��� �ݾƾߵȴ�.
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close(); // nullPointInception ����
            if (con != null)
               con.close();
         } catch (SQLException e) {
            // �ݴٰ� ������ �� ���� �־ Ʈ���� ĳġ
            e.printStackTrace();
         }

      }

      return list2;
   }
}