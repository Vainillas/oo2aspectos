package modelo;

public class Main {

  public static void main(String[] args) {
    Jugador milito = new Jugador("Gabriel Milito");
    Arbitro pierluigi = new Arbitro("Pierluigi Collina");
    milito.insultarA(pierluigi);
  }
}
