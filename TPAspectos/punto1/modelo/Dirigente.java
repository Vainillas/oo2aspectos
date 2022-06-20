package modelo;

public class Dirigente implements PersonaDelFutbol {
  private String nombre;

  public void insultarA(Arbitro arbitro) {
    arbitro.escuchar(this.insulto());
  }

  public String nombre() {
    return this.nombre;
  }

  public String insulto() {
    return "malo";
  }
}
