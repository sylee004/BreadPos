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

      // ResultSet 데이터를 갖고 있는 묶음
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
         // finally는 예외가 발생하던 안하던 무조건 실행
         // 연 순서와 반대대로 닫아야된다.
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close(); // nullPointInception 방지
            if (con != null)
               con.close();
         } catch (SQLException e) {
            // 닫다가 에러가 날 수도 있어서 트라이 캐치
            e.printStackTrace();
         }

      }

      return list;
   }
   
   public ArrayList<sale> selectOneByName(String name) {
      // 1. 데이터베이스와 연결, 드라이버클래스를 메모리에 로딩 Class.forName 안에 있다.

      // ResultSet 데이터를 갖고 있는 묶음
      ArrayList<sale> list2 = new ArrayList<>();
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // try/catch 실행
         // 연결해주도록 도와주는 클래스 DriverManager url , user ,password 입력해야 한다.
         // 이후에 또 try/catch 실행
         try {
            con = DriverManager.getConnection(url, user, password);
            String sql = "select sales from monthlysale where name = ?";

            psmt = con.prepareStatement(sql);

            psmt.setString(1, name);

            rs = psmt.executeQuery();

            while (rs.next()) {
               // rs.next커서 움직이는 방법

               double sale = rs.getDouble(1);
            
               // 인덱스는 Name PhoneNum Age 순으로 1,2,3이 붙는다.
               // 여기서 주의할 점은 결과 테이블의 순서라는 것이다.
               // 결과 테이블이 이름과 나이만 뽑는 것이라면 이름이 1 나이가 2번이 붙는다.

               sale m = new sale(sale);
               list2.add(m);
            }
         } catch (SQLException e) {

            e.printStackTrace();
         }
      } catch (ClassNotFoundException e) {

         e.printStackTrace();
      } finally {
         // finally는 예외가 발생하던 안하던 무조건 실행
         // 연 순서와 반대대로 닫아야된다.
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close(); // nullPointInception 방지
            if (con != null)
               con.close();
         } catch (SQLException e) {
            // 닫다가 에러가 날 수도 있어서 트라이 캐치
            e.printStackTrace();
         }

      }

      return list2;
   }
   
   public ArrayList<sale> selectByName(String name) {
      // 1. 데이터베이스와 연결, 드라이버클래스를 메모리에 로딩 Class.forName 안에 있다.

      // ResultSet 데이터를 갖고 있는 묶음
      ArrayList<sale> list2 = new ArrayList<>();
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // try/catch 실행
         // 연결해주도록 도와주는 클래스 DriverManager url , user ,password 입력해야 한다.
         // 이후에 또 try/catch 실행
         try {
            con = DriverManager.getConnection(url, user, password);
            String sql = "select month from monthlysale where name = ?";

            psmt = con.prepareStatement(sql);

            psmt.setString(1, name);

            rs = psmt.executeQuery();

            while (rs.next()) {
               // rs.next커서 움직이는 방법

               double month = rs.getDouble(1);
            
               // 인덱스는 Name PhoneNum Age 순으로 1,2,3이 붙는다.
               // 여기서 주의할 점은 결과 테이블의 순서라는 것이다.
               // 결과 테이블이 이름과 나이만 뽑는 것이라면 이름이 1 나이가 2번이 붙는다.

               sale m = new sale(month);
               list2.add(m);
            }
         } catch (SQLException e) {

            e.printStackTrace();
         }
      } catch (ClassNotFoundException e) {

         e.printStackTrace();
      } finally {
         // finally는 예외가 발생하던 안하던 무조건 실행
         // 연 순서와 반대대로 닫아야된다.
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close(); // nullPointInception 방지
            if (con != null)
               con.close();
         } catch (SQLException e) {
            // 닫다가 에러가 날 수도 있어서 트라이 캐치
            e.printStackTrace();
         }

      }

      return list2;
   }
}