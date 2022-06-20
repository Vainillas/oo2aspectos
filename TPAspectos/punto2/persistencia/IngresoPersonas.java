package persistencia;

import aspectos.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class IngresoPersonas {

  @Time
  public static void agregarPersonas(int cantPersonas) {
    ConectorDB conector = new ConectorDB();
    try {
      Connection conn = conector.connection();
      for (int i = 1; i <= cantPersonas; i++) {
        PreparedStatement s = conn.prepareStatement("INSERT INTO Personas VALUES (?)");
        s.setString(1, "Persona " + i);
        s.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
