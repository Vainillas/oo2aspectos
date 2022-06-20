package modelo;

public class Jugador implements PersonaDelFutbol {
	private String nombre;
	
	public Jugador(String nombre) {
		this.nombre=nombre;
	}

	public void insultarA(Arbitro unArbitro) {
		unArbitro.escuchar(this.insulto());
	}
	public String insulto() {
		return "malo";
	}
	public String nombre() {
		return this.nombre;
	}
}
