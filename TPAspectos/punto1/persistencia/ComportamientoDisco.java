package persistencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import modelo.Arbitro;
import modelo.PersonaDelFutbol;

public class ComportamientoDisco {

  public static void escribirInsulto(
    Arbitro unArbitro,
    PersonaDelFutbol unaPersona,
    String insulto
  ) {
    File miArchivo = new File("RegistroDeInsultos.txt");
    try {
      miArchivo.createNewFile();
      FileOutputStream File = new FileOutputStream(miArchivo, true);

      FileWriter myWriter = new FileWriter(miArchivo, true);
      myWriter.write(
        "El jugador " +
        unaPersona.nombre() +
        " le dijo " +
        unaPersona.insulto() +
        " a " +
        unArbitro.nombre()
      );
      myWriter.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
