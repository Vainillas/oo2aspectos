package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Arbitro;
import modelo.PersonaDelFutbol;

public class SQLImpl {
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

  public void registrarInsulto(
    Arbitro unArbitro,
    PersonaDelFutbol unaPersona,
    String insulto
  ) {
    PreparedStatement s;
    try {
      s = conn.prepareStatement("INSERT INTO insultos VALUES (?,?,?)");
      s.setString(1, unArbitro.nombre());
      s.setString(2, insulto);
      s.setString(3, unaPersona.nombre());
      s.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public void close() {
    try {
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
  }
}
