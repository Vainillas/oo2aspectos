package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorDB {
  private static String DRIVER = "com.mysql.jdbc.Driver";
  private static String URL_DB = "jdbc:mysql://localhost:3306/";
  protected static String DB = "objetos_tp_10";

  protected static String user = "root";
  protected static String pass = "";
  protected static Connection conn = null;

  private static void connect() throws SQLException {
    try {
      conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
    } catch (SQLException sqlEx) {
      throw sqlEx;
    }
  }

  public void open() {
    try {
      connect();
    } catch (SQLException sqlEx) {
      throw new RuntimeException();
    }
  }

  public Connection connection() {
    return conn;
  }

  public void close() {
    try {
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
  }
}
