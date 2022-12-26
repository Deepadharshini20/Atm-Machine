package atm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import user.User;

public class DatabaseHandler {
  static String url = null;
  static Connection con = null;

  public DatabaseHandler() {
    url = "jdbc:mysql://localhost:3306/atm";
    try {
      con = DriverManager.getConnection(url, "root", "root");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public User userExist(int accNo, int pin,String tableName) {
    String query = "select * from "+tableName+" where accountNo =" + accNo  + " and pin=" + pin;
    User u = null;
    try {
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      if (rs.next()) {
        u = new User();
        u.setAccNo(accNo);
        u.setPin(pin);
        u.setBalance(rs.getInt(3));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return u;
  }

  public void updateBalance(User u, String tableName) {
    String query = "update "+tableName+" set balance=" + u.getBalance() + " where accountNo =" + u.getAccNo();
    try {
      PreparedStatement st = con.prepareStatement(query);
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
